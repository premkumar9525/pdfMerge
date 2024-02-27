package com.example.demo.helper;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Random;
import java.util.TimeZone;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

public class Constants {
//	public static final String BASE_URL = "http://172.105.50.222/ixnixi/";
	public static final String BASE_IP = "localhost:9090/";
	public static final String BASE_DIR = "D:\\Spring_boot\\template\\src\\main\\resources\\static\\";
	public static final String BANNER_LOCATION = "images/";
	//public static final String BANNER_LOCATION = "/irinn_images/main_banner/";
	public static final String FOOTER_IMG_LOCATION = "/irinn_images/footer_img/";
	public static final String PHOTO_GALLERY_LOCATION = "/irinn_images/photo_gallery/";
	public static final String NEWS_IMG_LOCATION = "/irinn_images/news_img/";
	public static final String ABOUT_US_IMG_LOCATION = "/irinn_images/about_us_img/";
	public static final String WHYIPV6_IMG_LOCATION = "/irinn_images/whyIPv6_img/";
	public static final String RRS_IMG_LOCATION = "/irinn_images/rrs_img/";
	public static final String ITC_IMG_LOCATION = "/irinn_images/itc_img/";
	public static final String LOGO_IMG_LOCATION = "/irinn_images/logo_img/";
	public static final String PDF_LOCATION = "/irinn_pdf/";
	public static final String Training_N_Education_IMG_LOCATION = "/irinn_images/training_n_education_img/";
	public static final String RM_IMG_LOCATION = "/irinn_images/resource_management_img/";
	public static final String PROFILE_IMG_LOCATION = "/irinn_images/profile_img/";
	public static final String BANNER_SERVICE_IMG_LOCATION = "/irinn_images/banner_service_img/";
	public static final String IRINN_PROVIDE_IMG_LOCATION = "/irinn_images/irinn_provide/";
	public static final String WHAT_WE_HAVE_IMG_LOCATION = "/irinn_images/what-we-have/";
	public static final String EDITOR_IMG_LOCATION = "/irinn_images/editor_image/";
	public static final String TENDER_SERVICE_IMG_LOCATION = "/irinn_images/tender/";
	
	
	public static final String adminAdded = "adminAdded";
	public static final String emailAlreadyExist = "emailAlreadyExist";
	public static final String userNameAlreadyExist = "userNameAlreadyExist";
	public static final String mobileAlreadyExist = "mobileAlreadyExist";
	public static final String roleNotFound = "roleNotFound";
	public static final String badRequest = "badRequest";
	public static final String invalidData = "Invalid Data !!";
	public static final String loginSuccess = "loginSuccess";
	public static final String accountNotVerified = "Account not verified please verify your account";
	public static final String unathorized = "unathorized";
	public static final String userAdded = "userAdded";
	public static final String recordFetch = "recordFetch";
	public static final String invalidPasswordLength = "invalidPasswordLength";
	public static final String invalidUserNameLength = "invalidUserNameLength";
	public static final String invalidEmailLength = "invalidEmailLength";
	public static final String invalidMobileLength = "invalidMobileLength";
	public static final String userNameNotBlank = "userNameNotBlank";
	public static final String mobileNONotBlank = "mobileNONotBlank";
	public static final String emailNotBlank = "emailNotBlank";
	public static final String user_Info = "USER_INFO";
	public static final String requestSuccess = "Data add successfully !!";
	public static final String USER = "USER00";
	public static final String SUB_ADMIN = "SA00";
	public static final String permission = "Permission denied !!";
	public static final String datagetsucceed = "Data fatch successfully !!";
	public static final String addData = "Data add successfully !!";
	public static final String updateData = "Data update successfully !!";
	
	public static String getRandom() {
		String alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder sb = new StringBuilder();
		Random rnd = new Random();
		while (sb.length() < 8) {
			int index = (int) (rnd.nextFloat() * alpha.length());
			sb.append(alpha.charAt(index));
		}
		String saltStr = sb.toString();
		return saltStr;
	}

	public static String genrateOTP() {
		Random rndm_method = new Random();
		int[] otp = rndm_method.ints(6, 0, 9).toArray();
		StringBuilder sb = new StringBuilder();
		sb.append(otp[0]);
		sb.append(otp[1]);
		sb.append(otp[2]);
		sb.append(otp[3]);
		sb.append(otp[4]);
		sb.append(otp[5]);
		return sb.toString();
	}

	public static String getDateAndTime() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		df.setTimeZone(TimeZone.getTimeZone("Asia/Kolkata"));
		return String.valueOf(df.format(new Date()));
	}

	public static String getRandomPassword() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890@#!$_";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 8) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	public static String deleteMultiPartFile(String path, String fileName) {
		System.out.println("path for delete " + path);
		System.out.println("path for delete name " + path + fileName);
		File deletFile = new File(path + fileName);
		if (deletFile.delete()) {
			System.out.println("file deleted");
		} else {
			return "File not found";
		}
		return "File deleted Successfully";
	}
	public static String saveMultiPartFile(MultipartFile file, String path, String fileNameWithExtension) {
		if (file != null) {
			System.out.println(":::: Constant :::::  file ::::   "+file.toString()+":::: path ::::  "+path+"::::: fileNameWithExtension ::::   "+fileNameWithExtension.toString());
			
			////////
			File dir = new File(path + File.separator);
			if ((!dir.exists()) && (dir.mkdirs())) {
				System.out.println(" Directory Created Successfully ");
			}
			dir = new File(path + File.separator + fileNameWithExtension);
			System.out.println(" ABSOLUTE_PATH ::: " + dir.getAbsolutePath());
			
		
			try {
			
				FileOutputStream fileOuputStream = new FileOutputStream(dir);
				
				System.out.println(":::: fileOuputStream ::::   "+fileOuputStream.toString());
				Throwable localThrowable3 = null;
				try {
					fileOuputStream.write(file.getBytes());
					fileOuputStream.flush();
					fileOuputStream.close();
				} catch (Throwable localThrowable1) {
					localThrowable3 = localThrowable1;
					throw localThrowable1;
				} finally {
					if (fileOuputStream != null) {
						if (localThrowable3 != null) {
							try {
								fileOuputStream.close();
							} catch (Throwable localThrowable2) {
								localThrowable3.addSuppressed(localThrowable2);
							}
						} else {
							fileOuputStream.close();
						}
					}
				}
			} catch (Exception e) {
				System.out.println(" ::: EXCEPTION in save file  :::  " + e.getMessage());
			}
		}
		return fileNameWithExtension;
	}
	
	

	
	
	public static HashMap<String, Long> adminResp = new HashMap<String, Long>();

	public static void adminRespId() {
		System.err.println(":::Contstant Responsibities :::");
		// Settings Module
		adminResp.put("viewProfile", 2369L);
		adminResp.put("changePassword", 2370L);
		adminResp.put("updateProfile", 2371L);
		
		// MainLogo Module
		adminResp.put("addLogo", 185L);
		adminResp.put("logoList", 187L);
		adminResp.put("editLogo", 156L);
		adminResp.put("updateLogoStatus", 188L);
		adminResp.put("deleteLogo", 188L);

		// Header Management Module
		adminResp.put("addHeader", 193L);
		adminResp.put("headerList", 194L);
		adminResp.put("editHeader", 195L);
		adminResp.put("updateHeaderStatus", 196L);
		adminResp.put("deleteHeader", 196L);
		adminResp.put("menuListByMasterId", 269L);
		// Banner Management Module
		adminResp.put("addMainBanner", 189L);
		adminResp.put("mainBannerList", 190L);
		adminResp.put("editMainBanner", 191L);
		adminResp.put("updateMainBannerStatus", 192L);
		adminResp.put("deleteMainBanner", 192L);
		
		// Service Management Module
		adminResp.put("addService", 197L);
		adminResp.put("serviceList", 198L);
		adminResp.put("editService", 199L);
		adminResp.put("updateServiceStatus", 200L);
		adminResp.put("deleteService", 200L);
		
		// Photo Management Module
		adminResp.put("addPhoto", 201L);
		adminResp.put("photoList", 202L);
		adminResp.put("editPhoto", 203L);
		adminResp.put("updatePhotoStatus", 204L);
		adminResp.put("deletePhoto", 204L);
		
		// Video Management Module
		adminResp.put("addVideo", 205L);
		adminResp.put("videoList", 206L);
		adminResp.put("editVideo", 207L);
		adminResp.put("updateVideoStatus", 208L);
		adminResp.put("deleteVideo", 208L);
		
		
		// News Management Module
		adminResp.put("addNews", 209L);
		adminResp.put("newsList", 210L);
		adminResp.put("editNews", 211L);
		adminResp.put("updateNewsStatus", 212L);
		adminResp.put("deleteNews", 212L);		
		
		// Footer Management Module
		adminResp.put("addFooter", 213L);
		adminResp.put("footerList", 214L);
		adminResp.put("editFooter", 215L);
		adminResp.put("updateFooterStatus", 216L);
		adminResp.put("deleteFooter", 216L);

		// Page Management Module
		adminResp.put("addPage", 217L);
		adminResp.put("pageList", 218L);
		adminResp.put("editPage", 219L);
		adminResp.put("updatePageStatus", 220L);
		adminResp.put("deletePage", 220L);
		
		// EmailContent Management Module
		adminResp.put("addEmailContent", 221L);
		adminResp.put("emailContentList", 222L);
		adminResp.put("editEmailContent", 223L);
		adminResp.put("updateEmailContentStatus", 224L);
		adminResp.put("deleteEmailContent", 224L);
		
		//Banner Service Management Module
		adminResp.put("addBannerService",225L);
		adminResp.put("getBannerServiceList",226L);
		adminResp.put("editBannerServiceList",227L);
		adminResp.put("updateBannerServiceById",228L);
		adminResp.put("updateBannerServiceByStatus",229L);
		adminResp.put("deleteBannerServiceById",230L);
		
		//Irinn Provide  Management Module
	    adminResp.put("addIrinnProvide",231L);
	    adminResp.put("getIrinnProvideList",232L);
	    adminResp.put("getIrinnProvideById",233L);
	    adminResp.put("updateIrinnProvideById",234L);
	    adminResp.put("updateIrinnProvideByStatus",235L);
	    adminResp.put("getIrinnProvideByIdAndLanguageId",236L);
	    
	    
	    //addLanguage Module
	    adminResp.put("addLanguage",237L);
	    adminResp.put("getLanguageList",238L);
	    adminResp.put("getLanguageById",239L);
	    adminResp.put("updateLanguageById",240L);
	    adminResp.put("updateLanguageByStatus",241L);
	    
	  //what we Have   
	    adminResp.put("addWhatWeHaveData",244L);
	    adminResp.put("getWhatWeHaveList",245L);
	    adminResp.put("getWhatWeHaveByIdAndLanguageId",246L);
	    adminResp.put("updateWhatWeHaveById",247L);
	    adminResp.put("updateWhatWeHaveByStatus",248L);
	    adminResp.put("removeWhatWeHaveById",249L);
	    
	    //WhyIPv6 Operation
	    
	    adminResp.put("addWhyIPv6",250L);
	    adminResp.put("getwhyIPv6List",251L);
	    adminResp.put("getwhyIPv6ByIdAndLanguageId",252L);
	    adminResp.put("updateWhyIPv6ById",254L);
	    adminResp.put("deleteWhyIPv6ById",253L);
	    adminResp.put("updateWhyIPv6StatusById",254L);
    
	    //QuickLink Management Module
	    adminResp.put("addQuickLink",255L);
	    adminResp.put("getQuickLinkList",256L);
	    adminResp.put("getQuickLinkListById",257L);
	    adminResp.put("updateQuickLinkById",258L);
	    adminResp.put("updateQuickLinkByStatus",259L);
	    adminResp.put("removeQuickLinkById",260L);
	    
	    //Setting settingType

	    adminResp.put("getSettingTypeList",261L);
	    adminResp.put("uploadImageToEditor",262L);
	    
	    //Tender Management Module
	    adminResp.put("addTender",263L);
	    adminResp.put("getTenderList",264L);
	    adminResp.put("getTenderByid",265L);
	    adminResp.put("updateTenderByid",266L);
	    adminResp.put("removeTenderByid",267L);
	    adminResp.put("updateTenderByStatus",268L);
	    
	    // Feed Management Module
	    adminResp.put("addFeeCalculator",269L);
	    adminResp.put("getFeeCalculatorList",270L);
	    adminResp.put("getFeeCalculatorById",271L);
	    adminResp.put("updateFeeCalculator",272L);
	    adminResp.put("removeFeeCalculator",273L);
	    adminResp.put("searchIpBlock",280L);
	    
	    //Resource Management Module
	    adminResp.put("addResourcePartners",274L);
	    adminResp.put("getResourcePartnersList",275L);
	    adminResp.put("getResourcePartnersById",276L);
	    adminResp.put("updateResourcePartners",277L);
	    adminResp.put("updateResourcePartnersByStatus",278L);
	    adminResp.put("removeResourcePartners",279L);
	    
	}
	
	
	
	// Pagination  ===========
	 public static final String DEFAULT_PAGE_NUMBER = "1";
	    public  static final String DEFAULT_PAGE_SIZE = "10";
	    public static final String DEFAULT_SORT_BY = "id";
	    public static final String DEFAULT_SORT_DIRECTION = "asc";
}
