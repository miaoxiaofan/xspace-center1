package com.xspace.ordercenter.task;


import com.jcraft.jsch.*;
import com.jcraft.jsch.ChannelSftp.LsEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;
import java.util.Properties;
import java.util.Vector;


/**
 * sftp客户端
 * @author liujiayu
 *
 */
@Component
public class SftpClient {

    private String mHost;

    private int mPort = 22;

    private String mUsername;

    private String mPassword;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private ChannelSftp sftp = null;
    private Session sshSession = null;

    /*public static void main(String[] args)
    {
        System.out.println(Property.getProperty("file_mamager_plat_ip"));
    }*/
    public SftpClient(){
       /* this.mHost = Property.getProperty("file_mamager_plat_ip");
        this.mPort = Integer.valueOf(Property.getProperty("file_mamager_plat_port"));
        this.mUsername = Property.getProperty("file_mamager_plat_usrnm");
        this.mPassword = Property.getProperty("file_mamager_plat_psw");*/
    }

    public SftpClient(String host, int Port, String userName, String password){
        this.mHost = host;
        this.mPort = Port;
        this.mUsername = userName;
        this.mPassword = password;
    }

    /**
     * 初始化配置，外部调用
     * @param host
     * @param Port
     * @param userName
     * @param password
     */
    public void init(String host, int Port, String userName, String password){
        this.mHost = host;
        this.mPort = Port;
        this.mUsername = userName;
        this.mPassword = password;
    }
    public void reConnect(){
        try{
            this.connect();
        }catch (Exception e) {
            logger.warn("m_channel disconnect fail!", e);
        }
    }

    public boolean isNotConnected(){
        return sshSession == null;
    }

    public void connect() {
        JSch jsch = new JSch();
        try {
//            jsch.getSession(m_username,m_host, m_port);
            sshSession = jsch.getSession(mUsername, mHost, mPort);
            logger.info("username:" + mUsername + ", host:" + mHost + ",port:" + mPort);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");//不验证hostKey
            sshSession.setConfig(config);
            logger.debug("StrictHostKeyChecking", "no");
            sshSession.setPassword(mPassword);
            sshSession.connect();
            logger.debug("Session connected.");
            Channel channel = sshSession.openChannel("sftp");
            sftp = (ChannelSftp) channel;
            logger.debug("Opening Channel.");
            sftp.connect();
            logger.info("Connected to {} success! ",mHost);
        }
        catch (JSchException e) {
            logger.info("connected to " + mHost + "Fail!   错误：" + e.getMessage());
        }
    }

    public void disConnect() throws JSchException{
        if(sshSession == null){
            return;
        }
        synchronized (sshSession) {
            if(sftp.isConnected()){
                sftp.quit();
                sftp.disconnect();
            }
            if(sshSession.isConnected()){
                sshSession.disconnect();
            }
        }
    }

    public boolean isTryConnect(){
        int tryConnectCount = 0;
        try {
            while(true) {
                tryConnectCount++;
                if(sshSession.isConnected()){
                    return true;
                }else {
                    if(tryConnectCount >=3){
                        return false;
                    }else{
                        Thread.sleep(tryConnectCount*1000L);
                        this.reConnect();
                    }
                }
            }
        }catch (InterruptedException e) {
            // TODO Auto-generated catch block
            logger.error("m_chanel try connect interrupted!",e);
            Thread.currentThread().interrupt();
            return false;
        }
    }

    /**
     * 上传文件
     * 
     * @param remotePathDirName
     *            上传的目录
     * @param uploadFileName
     *            要上传的文件
     * @throws SftpException
     * @throws FileNotFoundException
     * @throws JSchException
     */
    public void upload(String remotePathDirName, String uploadFileName) {
        if(!this.isTryConnect()){
            logger.error("尝试连接SFTP服务器失败！");
        }
        try {
            sftp.cd(remotePathDirName);
            File uploadFile = new File(uploadFileName);
            sftp.put(new FileInputStream(uploadFile), uploadFile.getName());
            logger.debug("Upload file:{} to remote dir:{}", uploadFileName, remotePathDirName);
        }catch (FileNotFoundException e) {
            logger.error("Upload remote path({})FileNotFound{}",remotePathDirName, uploadFileName);
        }catch (SftpException e) {           
            logger.error("Upload remote path({}) not exists!{}",remotePathDirName, e);
        }
    }
    
    /**
     * 上传文件
     * 
     * @param remotePathDirName
     *            上传的目录
     * @param uploadFileName
     *            要上传的文件
     * @throws SftpException
     * @throws FileNotFoundException
     * @throws JSchException
     */
    public void upload(String remotePathDirName, InputStream is, String uploadFileName) {
        if(!this.isTryConnect()){
            logger.error("尝试连接SFTP服务器失败！");
        }
        try {
            sftp.cd(remotePathDirName);
			sftp.put(is, uploadFileName);
            logger.debug("Upload file:{} to remote dir:{}", uploadFileName, remotePathDirName);
        }
        catch (SftpException e) {           
            logger.error("download remote path({}) not exists!{}", remotePathDirName, e);
        }
    }

    public void uploadBatch(String directoryName,List<String> fileNameList) {
        for(String fileName:fileNameList){
            this.upload(directoryName, fileName);
        }
    }

    /**
     * 下载文件
     * 
     * @param remotePathDirName
     *            下载目录
     * @param downloadFileName
     *            下载的文件
     * @param localPathDirName
     *            存在本地的路径
     * @throws SftpException
     * @throws FileNotFoundException
     * @throws JSchException
     */
    public void download(String remotePathDirName,String localPathDirName, String downloadFileName) {
        if(!this.isTryConnect()){
            logger.error("尝试连接SFTP服务器失败！");
        }
        try {
        	//System.out.println(sftp.pwd());
            sftp.cd(remotePathDirName);
        	File fileDir=new File(localPathDirName);
            File saveFile = new File(localPathDirName + File.separator + downloadFileName);
            logger.info(saveFile.toString());
            if(!fileDir.exists()){
            	fileDir.mkdirs();
            }
            if(!saveFile.exists()){
            	saveFile.createNewFile();
            }
            sftp.get(downloadFileName, new FileOutputStream(saveFile));

        } catch (FileNotFoundException e) {
            logger.error("download remote path({})FileNotFound{}",remotePathDirName, downloadFileName);
        }catch (SftpException e) {           
            logger.error("download remote path({}) not exists!{}",remotePathDirName, e);
        } catch (IOException e) {
        	logger.error("create the file fail;");
			//e.printStackTrace();
		}
    }

    //读取订单对账信息
    public InputStream readOrderInfos(String remotePathDirName, String readFileName) {
        if(!this.isTryConnect()){
            logger.error("尝试连接SFTP服务器失败！");
        }
        InputStream inputStream=null;
        try {
            sftp.cd(remotePathDirName);
            inputStream=sftp.get(readFileName);
        }catch (SftpException e) {
            logger.error("read remote path({}) not exists!{}",remotePathDirName, e.getStackTrace());
        }
       return  inputStream;

    }

    public void downloadBatch(String directoryName,String localPathDirName, List<String> downloadFileNameList){
        for(String fileName:downloadFileNameList){
            this.download(directoryName, localPathDirName,fileName);
        }
    }


    /**
     * 删除文件
     * 
     * @param directory
     *            要删除文件所在目录
     * @param deleteFileName
     *            要删除的文件
     * @throws SftpException
     * @throws JSchException
     */
    public void delete(String directory, String deleteFileName) throws SftpException, JSchException {
        if(!this.isTryConnect()){
            logger.error("尝试连接SFTP服务器失败！");
        }
        sftp.cd(directory);
        sftp.rm(deleteFileName);
        logger.info("Delete file:{} from remote dir:{}", deleteFileName, directory);
    }

    /**
     * 重命名文件
     * @param remotePathDirName 远端ftp
     * @param oldName 原文件名
     * @param newName 更改為新的文件名
     * @throws SftpException
     * @throws JSchException
     */
    public void rename(String remotePathDirName,String oldName, String newName)throws SftpException, JSchException {
        if(!this.isTryConnect()){
            logger.error("尝试连接SFTP服务器失败！");
        }
        sftp.cd(remotePathDirName);
        sftp.rename(oldName, newName);
        logger.info("Rename filePath:{} fileOld:{} to  fileNew:{}", remotePathDirName,oldName, newName);
    }
    /**
     * 列出目录下的文件
     * @param directoryName
     *            要列出的目录
     * @return
     * @throws SftpException
     * @throws JSchException
     */
    @SuppressWarnings("unchecked")
    public Vector<LsEntry> listFiles(String directoryName) throws SftpException, JSchException {
        if(!this.isTryConnect()) {
            logger.error("尝试连接SFTP服务器失败！");
        }
        Vector<LsEntry> filesName = sftp.ls(directoryName);
        return filesName;
    }

    /**
     * 列出目录下符合要求的文件
     *
     *            要列出的目录
     * @param reg 文件名前缀
     * @param postfix 文件名后缀(格式)
     * @return
     * @throws SftpException
     * @throws JSchException
     */
    @SuppressWarnings("unchecked")
    public Vector<LsEntry> listFiles(String remotePathDirName, String reg, String postfix) {
        if(!this.isTryConnect()){
            logger.error("尝试连接SFTP服务器失败！");
        }
        Vector<LsEntry> filesName;
        try {
            filesName = sftp.ls(remotePathDirName);
            Vector<LsEntry> filterFilesName = new Vector<LsEntry> ();
            for (LsEntry lsEntry : filesName) {
                if(lsEntry.getFilename().indexOf(reg) > -1 && lsEntry.getFilename().endsWith(postfix)){
                    filterFilesName.add(lsEntry);
                }
            }
            return filterFilesName;
        } catch (SftpException e) {
            logger.error("download remote path({}) not exists!{}",remotePathDirName, e);
            return null;
        }
    }

    
    
    
    public String getmHost() {
		return mHost;
	}

	public void setmHost(String mHost) {
		this.mHost = mHost;
	}

	public int getmPort() {
		return mPort;
	}

	public void setmPort(int mPort) {
		this.mPort = mPort;
	}

	public String getmUsername() {
		return mUsername;
	}

	public void setmUsername(String mUsername) {
		this.mUsername = mUsername;
	}

	public String getmPassword() {
		return mPassword;
	}

	public void setmPassword(String mPassword) {
		this.mPassword = mPassword;
	}

}
