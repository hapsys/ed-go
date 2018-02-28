/**
 * 
 */
package org.c3s.edgo.web.common;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.c3s.annotations.Parameter;
import org.c3s.content.ContentObject;
import org.c3s.exceptions.FileSystemException;
import org.c3s.utils.FileSystem;
import org.commonmark.node.Link;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.AttributeProvider;
import org.commonmark.renderer.html.AttributeProviderContext;
import org.commonmark.renderer.html.AttributeProviderFactory;
import org.commonmark.renderer.html.HtmlRenderer;
/**
 * @author admin
 *
 */
public class MD2Html {

	public void publishMD(@Parameter("tag") String tag, @Parameter("source") String source) throws FileSystemException, IOException {
		//String content = FileSystem.fileGetContents(source);
		//System.out.println("|" + content + "|");
		File file = FileSystem.newFile(source);
		Parser parser = Parser.builder().build();
		Node document = parser.parseReader(new FileReader(file));
		HtmlRenderer renderer = HtmlRenderer.builder().attributeProviderFactory(new AttributeProviderFactory() {
			public AttributeProvider create(AttributeProviderContext context) {
				return new CommonAttributeProvider();
			}
		}).build();
		String result = renderer.render(document);
		ContentObject.getInstance().setData(tag, result);
	}
	
	
	public static class CommonAttributeProvider implements AttributeProvider {

		@Override
		public void setAttributes(Node node, String tagName, Map<String, String> attributes) {
			if (node instanceof Link) {
				 attributes.put("class", "text-primary");
			}
		}
		
	}
}
