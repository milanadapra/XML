<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:b="http://www.ftn.uns.ac.rs/XML" 
	xmlns:fo="http://www.w3.org/1999/XSL/Format" version="2.0">
	
	<xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="akt-page">
                    <fo:region-body margin="1in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
			
			 <fo:page-sequence master-reference="akt-page">
				<fo:flow flow-name="xsl-region-body">
					<fo:block font-family="sans-serif" font-size="32px" font-weight="bold"  text-align="center">
						<xsl:value-of select="b:Akt/@Naziv"/>
					</fo:block>
					<fo:block font-family="sans-serif" font-size="28px" font-weight="bold" padding="30px">
						 <xsl:for-each select="b:Akt/b:UvodniDeo">
							<fo:block>
								<xsl:for-each select="b:Glava">
									<fo:block font-family="sans-serif" font-size="24px" font-weight="bold"  text-align="center">
										<xsl:value-of select="@Naziv"/>
										<fo:block font-family="sans-serif" font-size="18px" font-weight="normal" text-align="center">
										<xsl:for-each select="b:Odredba">
											<fo:block>
											    <xsl:value-of select="@Naziv"/>
												<fo:block font-family="sans-serif" font-size="16px" font-weight="normal" text-align="center">
												<xsl:for-each select="b:Predmet">
													<fo:block>
														<xsl:value-of select="@Naziv"/>
														<fo:block font-family="sans-serif" font-size="17px" font-weight="bold" text-align="center">
														<xsl:for-each select="b:Clan">
															<fo:block>
																<xsl:value-of select="@Naziv"/>
																<fo:block font-family="sans-serif" font-size="17px" font-weight="normal" text-align="center">
																<xsl:for-each select="b:Stav">
																	<fo:block>
																		<xsl:value-of select="@Naziv"/>
																		<fo:block font-family="sans-serif" font-size="16px" font-weight="bold" text-align="left">
																		<xsl:for-each select="b:Tacka">
																			<fo:block>
																				<xsl:value-of select="@Naziv"/>)
																				<fo:block font-family="sans-serif" font-size="14px" font-weight="normal" text-align="left">
																				<xsl:value-of select="b:Sadrzaj"/>
																				<xsl:for-each select="b:Tacka">
																					<fo:block>
																						<xsl:value-of select="@Naziv"/>
																						<xsl:value-of select="b:Sadrzaj"/>
																					</fo:block>
																				</xsl:for-each>
																			</fo:block>
																			</fo:block>
																		</xsl:for-each>
																	</fo:block>
																	</fo:block>
																</xsl:for-each>
															</fo:block>
															</fo:block>
														</xsl:for-each>
													</fo:block>
													</fo:block>
												</xsl:for-each>
											</fo:block>
											</fo:block>
										</xsl:for-each>
									</fo:block>
									</fo:block>
								</xsl:for-each>
							
                            </fo:block>
						 </xsl:for-each>
                    </fo:block>
					<fo:block font-family="sans-serif" font-size="28px" font-weight="bold" padding="30px">
						<xsl:for-each select="b:Akt/b:GlavniDeo">
							<fo:block>
								<xsl:for-each select="b:Glava">
									<fo:block font-family="sans-serif" font-size="24px" font-weight="bold"  text-align="center">
										<xsl:value-of select="@Naziv"/>
										<fo:block font-family="sans-serif" font-size="18px" font-weight="normal" text-align="center">
											<xsl:for-each select="b:Odredba">
												<fo:block>
													<xsl:value-of select="@Naziv"/>
													<fo:block font-family="sans-serif" font-size="16px" font-weight="normal" text-align="center">
														<xsl:for-each select="b:Predmet">
															<fo:block>
																<xsl:value-of select="@Naziv"/>
																<fo:block font-family="sans-serif" font-size="17px" font-weight="bold" text-align="center">
																	<xsl:for-each select="b:Clan">
																		<fo:block>
																			<xsl:value-of select="@Naziv"/>
																			<fo:block font-family="sans-serif" font-size="17px" font-weight="normal" text-align="center">
																				<xsl:for-each select="b:Stav">
																					<fo:block>
																						<xsl:value-of select="@Naziv"/>
																						<fo:block font-family="sans-serif" font-size="16px" font-weight="bold" text-align="left">
																							<xsl:for-each select="b:Tacka">
																								<fo:block>
																									<xsl:value-of select="@Naziv"/>)
																										<xsl:value-of select="b:Sadrzaj"/>
																										<xsl:for-each select="b:Tacka">
																											<fo:block font-family="sans-serif" font-size="14px" font-weight="bold" padding="40px">
																												<xsl:value-of select="@Naziv"/>
																												<fo:block font-family="sans-serif" font-size="14px" padding="40px">
																													<xsl:value-of select="b:Sadrzaj"/>
																												</fo:block>
																											</fo:block>
																										</xsl:for-each>
																									
																								</fo:block>
																							</xsl:for-each>
																						</fo:block>
																					</fo:block>
																				</xsl:for-each>
																			</fo:block>
																		</fo:block>
																	</xsl:for-each>
																</fo:block>
															</fo:block>
														</xsl:for-each>
													</fo:block>
												</fo:block>
											</xsl:for-each>
										</fo:block>
									</fo:block>
								</xsl:for-each>
								
							</fo:block>
						</xsl:for-each>
					</fo:block>
					
					<fo:block font-family="sans-serif" font-size="28px" font-weight="bold" padding="30px">
						<xsl:for-each select="b:Akt/b:ZavrsniDeo">
							<fo:block>
								<xsl:for-each select="b:Glava">
									<fo:block font-family="sans-serif" font-size="24px" font-weight="bold"  text-align="center">
										<xsl:value-of select="@Naziv"/>
										<fo:block font-family="sans-serif" font-size="18px" font-weight="normal" text-align="center">
											<xsl:for-each select="b:Odredba">
												<fo:block>
													<xsl:value-of select="@Naziv"/>
													<fo:block font-family="sans-serif" font-size="16px" font-weight="normal" text-align="center">
														<xsl:for-each select="b:Predmet">
															<fo:block>
																<xsl:value-of select="@Naziv"/>
																<fo:block font-family="sans-serif" font-size="17px" font-weight="bold" text-align="center">
																	<xsl:for-each select="b:Clan">
																		<fo:block>
																			<xsl:value-of select="@Naziv"/>
																			<fo:block font-family="sans-serif" font-size="17px" font-weight="normal" text-align="center">
																				<xsl:for-each select="b:Stav">
																					<fo:block>
																						<xsl:value-of select="@Naziv"/>
																						<fo:block font-family="sans-serif" font-size="16px" font-weight="bold" text-align="left">
																							<xsl:for-each select="b:Tacka">
																								<fo:block>
																									<xsl:value-of select="@Naziv"/>)
																									<fo:block font-family="sans-serif" font-size="14px" font-weight="normal" text-align="left">
																										<xsl:value-of select="b:Sadrzaj"/>
																										<fo:block font-family="sans-serif" font-size="14px" font-weight="normal" text-align="left">
																										<xsl:for-each select="b:Tacka">
																											<fo:block>
																												<xsl:value-of select="@Naziv"/>)
																												<xsl:value-of select="b:Sadrzaj"/>
																											</fo:block>
																										</xsl:for-each>
																									</fo:block>
																								</fo:block>
																								</fo:block>
																							</xsl:for-each>
																						</fo:block>
																					</fo:block>
																				</xsl:for-each>
																			</fo:block>
																		</fo:block>
																	</xsl:for-each>
																</fo:block>
															</fo:block>
														</xsl:for-each>
													</fo:block>
												</fo:block>
											</xsl:for-each>
										</fo:block>
									</fo:block>
								</xsl:for-each>
								
							</fo:block>
						</xsl:for-each>
					</fo:block>
				</fo:flow>
			 </fo:page-sequence>
			
		</fo:root>
	</xsl:template>
</xsl:stylesheet>