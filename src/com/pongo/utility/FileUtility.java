package com.pongo.utility;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUtility {

	@Autowired
	private Environment environment;

	/**
	 * Method to save the images on a particular path and return new image name.
	 * 
	 * @param files
	 * @param folderName
	 * @return
	 */
	public String saveFile(File files) {
        String finalName = null;
        try {
                String fileName = files.getName().trim();
                if (fileName != null && fileName.length() != 0) {
                    FileInputStream fileInputStream=null;
                    byte[] bFile = new byte[(int) files.length()];
                        //convert file into array of bytes
                    fileInputStream = new FileInputStream(files);
                    fileInputStream.read(bFile);
                    fileInputStream.close();
                    int index = fileName.lastIndexOf('.');
                    String path =  environment.getRequiredProperty("userFilePath");
                    File dir = new File(path);
                    if (!dir.exists())
                        dir.mkdirs();
                    finalName = fileName.substring(0, index)+System.currentTimeMillis()
                            +fileName.substring(index);
                    StringBuffer sb = new StringBuffer();
                    sb.append(path);
                    sb.append(finalName);
                    BufferedOutputStream buffStream = new BufferedOutputStream(
                            new FileOutputStream(new File(sb.toString())));
                    buffStream.write(bFile);
                    buffStream.close();
                }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return finalName;
    }
	public String saveFile(MultipartFile files) {
		String finalName = null;
		try {
				String fileName = files.getOriginalFilename().trim();
				if (fileName != null && fileName.length() != 0
						&& files.getBytes().length != 0) {
					byte[] bytes = files.getBytes();
					int index = fileName.lastIndexOf('.');
					String path =  environment.getRequiredProperty("userFilePath");
					File dir = new File(path);
	                if (!dir.exists())
	                    dir.mkdirs();
					
	                finalName = fileName.substring(0, index)+System.currentTimeMillis()
	                		+fileName.substring(index);
	                
					StringBuffer sb = new StringBuffer();
					sb.append(path);
					sb.append(finalName);
					BufferedOutputStream buffStream = new BufferedOutputStream(
							new FileOutputStream(new File(sb.toString())));
					buffStream.write(bytes);
					buffStream.close();
				}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return finalName;
	}
	
	/**21-11-2016
	 * 
	 * @param imgs
	 * @return
	 */
	public String saveImage(MultipartFile imgs) {
		String finalName = null;
		try {
				String fileName = imgs.getOriginalFilename().trim();
				if (fileName != null && fileName.length() != 0
						&& imgs.getBytes().length != 0) {
					byte[] bytes = imgs.getBytes();
					int index = fileName.lastIndexOf('.');
					String path =  environment.getRequiredProperty("userFilePath");
					File dir = new File(path);
	                if (!dir.exists())
	                    dir.mkdirs();
					
	                finalName = fileName.substring(0, index)+System.currentTimeMillis()
	                		+fileName.substring(index);
	                
					StringBuffer sb = new StringBuffer();
					sb.append(path);
					sb.append(finalName);
					BufferedOutputStream buffStream = new BufferedOutputStream(
							new FileOutputStream(new File(sb.toString())));
					buffStream.write(bytes);
					buffStream.close();
				}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return finalName;
	}

	public List<String> saveImage(MultipartFile[] files, String contextPath) {
		String finalName = null;
		List<String> nameList = new ArrayList<String>();
		try {
			for (int i = 0; i < files.length; i++) {
				String fileName = files[i].getOriginalFilename().trim();
				if (fileName != null && fileName.length() != 0
						&& files[i].getBytes().length != 0) {
					byte[] bytes = files[i].getBytes();
					int index = fileName.lastIndexOf('.');
					String path =  environment.getRequiredProperty("userFilePath");
					File dir = new File(path);
	                if (!dir.exists())
	                    dir.mkdirs();
					
	                finalName = fileName.substring(0, index)+System.currentTimeMillis()
	                		+fileName.substring(index);
	                
					StringBuffer sb = new StringBuffer();
					sb.append(path);
					sb.append(finalName);
					nameList.add(finalName);
					BufferedOutputStream buffStream = new BufferedOutputStream(
							new FileOutputStream(new File(sb.toString())));
					buffStream.write(bytes);
					buffStream.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return nameList;
	}

	
	//used in mail send voucher
	
	public File getVoucherImage(String imageName){
		File file = null;
		try {
			String imagePath = environment.getRequiredProperty("userFilePath")+imageName;
			if(!imagePath.equals(null) && !imagePath.equalsIgnoreCase("null") && !imagePath.isEmpty()){
				file = new File(imagePath);
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}
	
	
}
