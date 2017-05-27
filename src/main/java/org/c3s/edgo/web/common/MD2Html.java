/**
 * 
 */
package org.c3s.edgo.web.common;

import java.io.File;
import java.io.IOException;

import org.c3s.annotations.Parameter;
import org.c3s.content.ContentObject;
import org.c3s.exceptions.FileSystemException;
import org.c3s.utils.FileSystem;

import com.github.rjeschke.txtmark.Processor;

/**
 * @author admin
 *
 */
public class MD2Html {

	public void publishMD(@Parameter("tag") String tag, @Parameter("source") String source) throws FileSystemException, IOException {
		//System.out.println("----");
		//String md = FileSystem.fileGetContents(source);
		File file = FileSystem.newFile(source);
		String result = Processor.process(file);
		ContentObject.getInstance().setData(tag, result);
		//System.out.println(">>>>");
		//System.out.println(result);
	}
	
}
