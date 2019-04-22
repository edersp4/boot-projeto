package application.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipInputStream;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;



/**
 * Utility to Zip and Unzip nested directories recursively.
 * @author Robin Spark
 */
public class ZipUtil {

		public static void zipFolder(String nameFolderZip,File fileSourceFolder) throws ZipException {
			ZipParameters parameters = new ZipParameters();
	    	ZipFile zipe = new ZipFile( nameFolderZip );
	    	// set compression method to store compression
	    	parameters.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);

	    	  // Set the compression level
	    	parameters.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
	    	zipe.addFolder(fileSourceFolder, parameters);
		}
}


