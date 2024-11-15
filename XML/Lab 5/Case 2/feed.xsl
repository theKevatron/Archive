<?xml version="1.0" encoding="UTF-8" ?>
<!--
   New Perspectives on XML, 3rd Edition
   Tutorial 5
   Case Problem 2
   Twin Life News XSLT Style Sheet
   Filename:         feed.xsl
   Supporting Files: 
-->

<xsl:stylesheet version="1.0"
     xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
     xmlns:atom="http://www.w3.org/2005/Atom" 
     xmlns:story="http://example.com/news/" 
     xmlns:media="http://example.com/media/">
	 
   <xsl:template match="/">
	  <html> 
		 <head> 
		    <title>
			   <xsl:value-of select="rss/channel/title" />
			</title> 
			<link href="feedstyles.css" rel="stylesheet" type="text/css" /> 
		 </head> 
		 
		 <body> 
		 
			<div id="head">
			   <h1>
				  <xsl:value-of select="rss/channel/title" />
			   </h1>
			   <p>
				  <xsl:value-of select="rss/channel/description" />
			   </p>
			   <p><a href="{channel/title/atom:link}">Subscribe</a></p>
			</div>
			
			<div id="sidebar">
			   <h1>Recent Articles</h1>
			   <xsl:for-each select="rss/channel/item">
				  <p>
					 <a href="#{guid}">
						<xsl:value-of select="story:subhead" />
					 </a>
				  </p>
			   </xsl:for-each>
			</div>
			
			<xsl:apply-templates select="rss/channel/item" />
		 </body> 
		 
	  </html>
   </xsl:template>
   
   <xsl:template match="item">
	   <div class="article">
		  <h1 id="{guid}">
			 <xsl:value-of select="title" />
		  </h1>
		  <h2>
			 By:
			 <xsl:value-of select="story:author" />
		  </h2>
		  <h3>
			 <xsl:value-of select="pubDate" />
		  </h3>
		  <div class="outtake">
			 <xsl:value-of select="description" disable-output-escaping="yes" />
		  </div>
		  <p>
			 [<a href="{link}">More ...</a>]
		  </p>
	   </div>
    </xsl:template>

</xsl:stylesheet>
