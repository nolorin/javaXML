package javaXML;
/** Contains the attributes and other pertanent information for an XML node.
 * @author nolorin
 * @author www.github.com/nolorin
 * @version 1.0
 * @since 1.0
 */
public class XMLNode {
	public boolean decl = false;
	public String version = "1.0";
	public String encoding = "UTF-8";
	public static String indentChar = "\t";

	public String name;
	public String innerHTML = "";
	public boolean shortTag = false;
	public boolean closingTag = false;
	public int parentKey = 0;
	protected String tag;
	protected String[] attrNames = {};
	protected String[] attrValues = {};

	protected String[] childrenNames = {};
	protected XMLNode[] childrenNodes = {};
	/** Class constructor.
	 * @param tag Tag name
	 * @param shortTag Indicates whether node needs to be closed or not
	 */
	public XMLNode( String name, String tag, boolean shortTag ) {
		this.name = name;
		this.tag = tag;
		this.shortTag = shortTag;
	}
	/** Sets the value of an attribute of the XML node
	 * @param name The name of the attribute
	 * @param value The value of the attribute
	 */
	public void setAttr( String name, String value ) {
		this.attrNames = XMLFunctions.strAppend( this.attrNames, name );
		this.attrValues = XMLFunctions.strAppend( this.attrValues, value );
	}
	/** Retrieves an attribute value for a given attribute name
	 * @param name The name of the attribute
	 * @return The value of the requested attribute
	 */
	public String getAttr( String name ) {
		String avalue = "";
		for( int i=0; i<this.attrNames.length; i++ ) {
			String aname = this.attrNames[i];
			if( aname == name ) {
				return attrValues[i];
			}
		}
		return "";
	}
	/** Method for retrieving array key for a given child XMLNode
	 * @param name Name of child XMLNode
	 */
	public int getNodeKey( String name ) {
		for( int i=0; i<this.childrenNames.length; i++ ) {
			if( this.childrenNodes[i].name == name ) {
				return i;
			}
		}
		return -1;
	}
	/** Method for adding a child.
	 * @param child Child XMLNode to be added
	 */
	public void addChild( XMLNode child ) {
		this.childrenNames = XMLFunctions.strAppend( this.childrenNames, child.name );
		this.childrenNodes = XMLFunctions.nodeAppend( this.childrenNodes, child );
	}
	/** Method for removing a child.
	 * @param child Child XMLNode to be added
	 */
	public void removeChild( int childKey ) {
		this.childrenNames = XMLFunctions.strRemove( this.childrenNames, childKey );
		this.childrenNodes = XMLFunctions.nodeRemove( this.childrenNodes, childKey );
	}
	/** Method for removing a child by XMLNode name.
	 * @param child Child XMLNode to be added
	 */
	public void removeChildByName( String childName ) {
		int childKey = getNodeKey( childName );
		this.childrenNames = XMLFunctions.strRemove( this.childrenNames, childKey );
		this.childrenNodes = XMLFunctions.nodeRemove( this.childrenNodes, childKey );
	}

	/** Prints out a string XML representation of XMLNode object.
	 * @return String representation
	 */
	protected String printFull( String indent, String endLine, String indentInherit ) {
		int i = 0;
		boolean neat = indent == "" && endLine == "" ? false : true;
		indent = indent + indentInherit;
		String output = this.decl ? "<?xml version=\"" + this.version + "\" encoding=\"" + this.encoding + "\">" + endLine : "";
		output += "<" + this.tag;
		if( this.attrNames.length > 0 ) {
			output += " ";
			for( i=0; i<this.attrNames.length; i++ ) {		
				output += this.attrValues[i] != null ? this.attrNames[i] + "=\"" + this.attrValues[i] + "\" " : this.attrNames[i] + " ";
			}
			output = output.trim();
		}
		output += this.shortTag ? " />" + endLine : ">" + endLine;
		for( i=0; i<this.childrenNodes.length; i++ ) {
			if( neat && this.childrenNodes[i].childrenNodes.length == 0 && this.childrenNodes[i].innerHTML == "" ) {
				output += indent + this.childrenNodes[i].printFull( "", "", "" ) + endLine;				
			} else {
				output += indent + this.childrenNodes[i].printFull( indent, endLine, indent ) + endLine;				
			}
		}
		if( this.innerHTML != "" ) {
			output += indent + this.innerHTML + endLine;
		}
		output += indentInherit + "</" + this.tag + ">";
		return output;
	}

	public String print() {
		return this.printFull( "", "", ""  );
	}
	public String printNeat() {
		return this.printFull( "\t", "\n", "" );
	}
}
