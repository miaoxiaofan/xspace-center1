package com.xspace.commoncenter.io;

import java.io.*;

/**
 * @author wmiao   输入输出字节流
 * @description TODO
 * @date 2020/5/24 20:21
 */
public class StreamDemo1 {

    /**
     * 基础字节输入输出流
     *
     * @param inPath
     * @param outPath
     */
    public void demo1(String inPath, String outPath) {

        try (InputStream a = new FileInputStream(inPath);
             OutputStream b = new FileOutputStream(outPath);) {
            byte[] bytes = new byte[1024];
            int length = -1;
            while ((length = a.read(bytes)) != -1) {
                String msg = new String(bytes);
                System.out.println(msg);
                b.write(bytes);
            }
            b.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 低级字符流
     *
     * @param inPath
     * @param outPath
     */
    public void demo2(String inPath, String outPath) {

        try (FileReader a = new FileReader(new File(inPath));
             FileWriter b = new FileWriter(outPath)) {
            char[] chars = new char[1024];
            int mlengths = -1;
            while ((mlengths = a.read(chars)) != -1) {
                b.write(chars.toString());
            }
            b.flush();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 中级字符流 (设置字符编码)
     *
     * @param inPath
     * @param outPath
     */
    public void demo3(String inPath, String outPath) {
        try (InputStreamReader a = new InputStreamReader(new FileInputStream(inPath), "utf-8");
             Writer b = new OutputStreamWriter(new FileOutputStream(outPath, true), "utf-8")) {
            char[] bytes = new char[1024];
            int mLength = -1;
            while ((mLength = a.read(bytes)) != -1) {
                b.write(bytes.toString());
                b.flush();
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    /**
     * 缓冲字符流
     *
     * @param inPath
     * @param outPath
     */
    public void demo4(String inPath, String outPath) {

        try (BufferedReader a = new BufferedReader(new InputStreamReader(new FileInputStream(inPath), "utf-8"));
             BufferedWriter b = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outPath, true), "utf-8"))) {
            String str = null;
            while ((str = a.readLine()) != null) {
                b.write(str);
                b.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }





    /**
     * 缓冲字符流
     *
     * @param inPath
     * @param outPath
     */
    public void demo5(String inPath, String outPath) {

        try (BufferedInputStream a = new BufferedInputStream(new FileInputStream(inPath));
             BufferedOutputStream b = new BufferedOutputStream(new FileOutputStream(outPath, true)) ){
            byte[] bytes = new byte[1024];
            int mLengths =-1;
            while ((mLengths = a.read(bytes)) != -1) {
                b.write(bytes,0,mLengths);
                b.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}

