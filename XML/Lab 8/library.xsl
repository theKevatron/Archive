<?xml version="1.0" encoding="UTF-8" ?>
<!--
   New Perspectives on XML, 3rd Edition
   Tutorial 8
   Tutorial Project
   Denison Public Library XSLT Style Sheet
   Filename:         library.xsl
   Supporting Files: book.png, dvd.png
-->

<xsl:stylesheet version="2.0"
     xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
     xmlns:xs="http://www.w3.org/2001/XMLSchema"
     exclude-result-prefixes="xs">

   <xsl:output method="html"
      doctype-system="about:legacy-compat"
      encoding="UTF-8"
      indent="yes" />

   <xsl:variable name="thisDate" select="xs:date('2017-04-12')" />

   <xsl:template match="/">

      <html>
         <head>
            <title>Denison Public Library</title>
            <link href="libstyles.css" rel="stylesheet" type="text/css" />
         </head>

         <header>
            <h1>Denison Public Library</h1>
            <h2>Ennis, Montana</h2>
         </header>

         <body>
		   <h2><xsl:value-of select="format-date($thisDate,'[MNn] [D], [Y]')" /></h2>
               <h1>Checked Out Items</h1>
               <table id="checkoutList">
                  <thead>                  
                     <tr>
                        <th>Call No.</th>
                        <th>Title</th>
                        <th>Due Date</th>
                        <th>Overdue? (Y/N)</th>
                        <th>Overdue Category</th>
                     </tr>
                  </thead>	
                  <tbody>			
       	          <xsl:apply-templates select="itemlist/item" />
                  </tbody>
               </table>
         </body>

      </html>
   </xsl:template>

   <xsl:template match="item">
      <tr>
         <td class="callnoCell">
            <xsl:value-of select="callno" />
         </td>
         <td class="titleCell">
            <xsl:value-of select="title" />
         </td>
         <td class="duedateCell">
            <xsl:value-of select="status/@return" />
         </td>
         <td class="overdueCell">
	   <xsl:variable name="overdue" select="if ($thisDate > status/@return) then 'Y' else 'N'" />
	   <xsl:value-of select="$overdue" />
         </td>
         <td class="categoryCell">
			<xsl:variable name="longoverdueDate" select="$thisDate - xs:dayTimeDuration('P30D')" as="xs:date" />
			<xsl:variable name="lostDate" select="$thisDate - xs:dayTimeDuration('P90D')" as="xs:date" />
			<xsl:variable name="category" select="if(status/@return &lt; $lostDate) then 'Lost'
			else if(status/@return &lt; $longoverdueDate) then 'Long Overdue'
			else if($thisDate > status/@return) then 'Overdue'
			else ''" />
			<xsl:value-of select="$category" />
         </td>
      </tr>
   </xsl:template>

</xsl:stylesheet>
