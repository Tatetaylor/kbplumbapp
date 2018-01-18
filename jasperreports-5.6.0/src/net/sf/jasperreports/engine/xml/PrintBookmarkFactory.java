/*
 * JasperReports - Free Java Reporting Library.
 * Copyright (C) 2001 - 2013 Jaspersoft Corporation. All rights reserved.
 * http://www.jaspersoft.com
 *
 * Unless you have purchased a commercial license agreement from Jaspersoft,
 * the following license terms apply:
 *
 * This program is part of JasperReports.
 *
 * JasperReports is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JasperReports is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with JasperReports. If not, see <http://www.gnu.org/licenses/>.
 */
package net.sf.jasperreports.engine.xml;

import net.sf.jasperreports.engine.base.BasePrintBookmark;

import org.xml.sax.Attributes;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JRPrintPageFactory.java 5878 2013-01-07 20:23:13Z teodord $
 */
public class PrintBookmarkFactory extends JRBaseFactory
{
	

	/**
	 *
	 */
	public Object createObject(Attributes atts)
	{
		String label = atts.getValue(JRXmlConstants.ATTRIBUTE_label);
		
		int pageIndex = 0;
		String strPageIndex = atts.getValue(JRXmlConstants.ATTRIBUTE_pageIndex);
		if (strPageIndex != null && strPageIndex.length() > 0)
		{
			pageIndex = Integer.parseInt(strPageIndex);
		}

		String elementAddress = atts.getValue(JRXmlConstants.ATTRIBUTE_elementAddress);
		
		return new BasePrintBookmark(label, pageIndex, elementAddress);
	}
	

}
