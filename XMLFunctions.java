package javaXML;
/** Contains static functions used in the package.
 * static methods for parsing and printing XML strings.
 * @author nolorin
 * @author www.github.com/nolorin
 * @version 1.0
 * @since 1.0
 */
public class XMLFunctions {
	/** Appends an XMLNode object to an XMLNode array.
	 * @param array The XMLNode array before appending
	 * @param appendable The XMLNode object to be appended
	 * @return The appended array
	 */
	public static XMLNode[] nodeAppend( XMLNode[] array, XMLNode appendable ) {
		XMLNode[] newArray = new XMLNode[array.length+1];
		int i = 0;
		for( i=0; i<array.length; i++ ) {
			newArray[i] = array[i];
		}
		newArray[array.length] = appendable;
		return newArray;
	}
	/** Removes an XMLNode object from an XMLNode array.
	 * @param array The XMLNode array before appending
	 * @param int The int key for the XMLNode object to be removed
	 * @return The ammended array
	 */
	public static XMLNode[] nodeRemove( XMLNode[] array, int itemKey ) {
		XMLNode[] newArray = new XMLNode[array.length];
		int correction = 0;
		int i = 0;
		for( i=0; i<array.length; i++ ) {
			if( i != itemKey ) {
				newArray[i+correction] = array[i];				
			} else {
				correction = -1;
			}
		}
		return newArray;
	}
	/** Appends a String to a String array.
	 * @param array The String array before appending
	 * @param appendable The String to be appended
	 * @return The appended array
	 */
	public static String[] strAppend( String[] array, String appendable ) {
		String[] newArray = new String[array.length+1];
		int i = 0;
		for( i=0; i<array.length; i++ ) {
			newArray[i] = array[i];
		}
		newArray[array.length] = appendable;
		return newArray;
	}
	/** Inserts a String into an array after a specific index.
	 * @param array The String array before appending
	 * @param afterIndex The key index after which the instertable should be inserted
	 * @param insertable The String to be inserted
	 * @return The appended array
	 */
	public static String[] strInsertAfter( String[] array, int afterIndex, String insertable ) {
		String[] newArray = new String[array.length+1];
		int i = 0;
		for( i=0; i<newArray.length; i++ ) {
			if( i == afterIndex ) {
				newArray[i] = insertable;
			} else {
				newArray[i] = array[i];
			}
		}
		return newArray;
	}
	/** Removes an XMLNode object from an XMLNode array.
	 * @param array The XMLNode array before appending
	 * @param int The int key for the XMLNode object to be removed
	 * @return The ammended array
	 */
	public static String[] strRemove( String[] array, int itemKey ) {
		String[] newArray = new String[array.length];
		int correction = 0;
		int i = 0;
		for( i=0; i<array.length; i++ ) {
			if( i != itemKey ) {
				newArray[i+correction] = array[i];				
			} else {
				correction = -1;
			}
		}
		return newArray;
	}
	/** Appends an int to an int array.
	 * @param array The int array before appending
	 * @param appendable The int to be appended
	 * @return The appended array
	 */
	public static int[] intAppend( int[] array, int appendable ) {
		int[] newArray = new int[array.length+1];
		int i = 0;
		for( i=0; i<array.length; i++ ) {
			newArray[i] = array[i];
		}
		newArray[array.length] = appendable;
		return newArray;
	}
	/** Removes an XMLNode object from an XMLNode array.
	 * @param array The XMLNode array before appending
	 * @param int The int key for the XMLNode object to be removed
	 * @return The ammended array
	 */
	public static int[] intRemove( int[] array, int itemKey ) {
		int[] newArray = new int[array.length];
		int correction = 0;
		int i = 0;
		for( i=0; i<array.length; i++ ) {
			if( i != itemKey ) {
				newArray[i+correction] = array[i];				
			} else {
				correction = -1;
			}
		}
		return newArray;
	}
}
