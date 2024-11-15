<?xml version="1.0" encoding="UTF-8" ?>
<!--
   New Perspectives on XML, 3rd Edition
   Tutorial 6
   Case Problem 2

   Karleton Manufacturing Style Sheet
   Author: Kevin Morales
   Date:	11/8/2021

   Filename:         spc.xsl
   Supporting Files: 
-->


<xsl:stylesheet version="1.0"
     xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

   <xsl:output method="html"
      doctype-system="about:legacy-compat"
      encoding="UTF-8"
      indent="yes" />
	  
   <xsl:param name="sampleID" select="'A100'" />
   <xsl:include href="spcfunctions.xsl" />

   <xsl:template match="/">
      <html>
         <head>
            <title>Statistical Processing Control Results</title>
            <link href="kmstyles.css" rel="stylesheet" type="text/css" />
         </head>

         <body>
            <div id="wrap">
               <header>
                  <img src="kmlogo.png" alt="Karleton Manufacturing" />
               </header>

               <h1>Quality Control Analysis</h1>
			   <xsl:apply-templates select="samples/sample[@sampleID=$sampleID]" />

             </div>
         </body>
      </html>

   </xsl:template>

   <xsl:template match="sample">
	  <h2>Sample: <xsl:value-of select="@sampleID" /></h2>
      <table id="batchTable">
         <thead>
            <tr>
               <th>Batch</th>
               <th>Sample Size</th>
               <th>Minimum</th>
               <th>Maximum</th>
               <th>Average</th>
               <th>Standard Error</th>
               <th><img src="grid.png" alt="" /></th>
            </tr>
         </thead>
         <tbody>
            <xsl:apply-templates select="batch" />
         </tbody>
      </table>
   </xsl:template>

   <xsl:template match="batch">
	  <xsl:variable name="minWidth">
         <xsl:call-template name="minimum">
            <xsl:with-param name="list" select="width" />
         </xsl:call-template>
      </xsl:variable>
      <xsl:variable name="maxWidth">
         <xsl:call-template name="maximum">
            <xsl:with-param name="list" select="width" />
         </xsl:call-template>
      </xsl:variable>
      <xsl:variable name="avgWidth">
         <xsl:call-template name="average">
            <xsl:with-param name="list" select="width" />
         </xsl:call-template>
      </xsl:variable>
      <xsl:variable name="stdErrWidth">
         <xsl:call-template name="stdErr">
            <xsl:with-param name="list" select="width" />
         </xsl:call-template>
      </xsl:variable>
      <xsl:variable name="lowerCI" select="$avgWidth - 1.96*$stdErrWidth" />
      <xsl:variable name="upperCI" select="$avgWidth + 1.96*$stdErrWidth" />

      <tr>
         <td>
            <xsl:value-of select="@batchID" />
         </td>
         <td>
            <xsl:value-of select="count(width)" />
         </td>
         <td>
            <xsl:value-of select="format-number($minWidth, '#0.00')" />
          </td>
         <td>
            <xsl:value-of select="format-number($maxWidth, '#0.00')" />
          </td>
          <td>

             <xsl:value-of select="format-number($avgWidth, '#0.00')" />
         </td>
         <td>
            <xsl:value-of select="format-number($stdErrWidth, '#0.000')" />
         </td>
         <td>
            <img src="background.png" height="22px"
             width="{concat(25*($lowerCI - 58), 'px')}" alt="{$lowerCI}" />
            <img src="lowerbar.png" height="22px"
             width="{concat(25*($avgWidth - $lowerCI), 'px')}" alt="{$avgWidth}" />
            <img src="upperbar.png" height="22px"
             width="{concat(25*($upperCI - $avgWidth), 'px')}" alt="{$upperCI}" />
            <img src="background.png" height="22px"
             width="{concat(25*(72 - $upperCI), 'px')}" alt="" />
         </td>
      </tr>
   </xsl:template>


</xsl:stylesheet>

