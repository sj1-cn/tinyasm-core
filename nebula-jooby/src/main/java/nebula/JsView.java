
package nebula;

import org.jooby.MediaType;
import org.jooby.View;


public class JsView extends View {

	protected JsView(String name) {
		super(name);
		type(MediaType.js);
	}

}
