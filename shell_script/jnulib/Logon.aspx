
























 
 
































<!-- portal sso -->

<!-- proxy -->



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<title> 전남대학교 중앙도서관</title>
	<link rel="stylesheet" type="text/css" href="/style/ko/common.css">
	<link rel="stylesheet" type="text/css" href="/style/ko/sub.css">
	<script type="text/javascript" src="/js/common/jquery.js"></script>
	<script type="text/javascript" src="/js/common/jquery.animate.clip.js"></script>
	<script type="text/javascript" src="/script/jqueryCommon.js"></script>
	<script type="text/javascript" src="/script/common.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			
		//portal sso
		
		 	
			location.href="/tulip/jsp/theme/chonnam/sslReturn.jsp?uid=NzA1NTY=&goPage=/tulip/jsp/theme/chonnam/logon.jsp";
		
		
		//primo
		
		
		//proxy
		
		});
	</script>
	<script type="text/javascript">
		var nowZoom = 100;
		var maxZoom = 200;
		var minZoom = 80;
		
		function zoomOut(){
			if(nowZoom < maxZoom){
				nowZoom += 5;
			}else{
				return;
			}
			document.getElementById("divWrapper").style.zoom = nowZoom + "%";
		}
		function zoomIn(){
			if(nowZoom > minZoom){
				nowZoom -= 5;
			}else{
				return;
			}
			document.getElementById("divWrapper").style.zoom = nowZoom + "%";
		}
		function origin(){
			nowZoom = 100;
			document.getElementById("divWrapper").style.zoom = nowZoom + "%";
		}
	</script>
	<basefont size=2>
</head>
<body>
<div id="accessibility">
	<ul>
		<li><a href="#divTopMenu">주메뉴 바로가기</a></li>
		<li><a href="#divContents">본문 바로가기</a></li>
        <li><a href="#divQuick">퀵메뉴 바로가기</a></li>
        <li><a href="#divMyMenu">마이메뉴 바로가기</a></li>
		<li><a href="#divFooter">도서관 정보 바로가기</a></li>
	</ul>
</div>
<div id="divWrapper">
	<div id="divHeader" class="divStaff">
		<h1><a href="/"><img src="/image/ko/local/libCLogo01.gif" alt="전남대학교 중앙도서관"></a></h1>
		<!-- //h1 -->
		<div id="divGlobalMenu">
			<div class="globalTab">
				<ul>
					<li><img src="/image/ko/local/globalMenu01On.gif" alt="중앙도서관"></li>
					<li><a href="http://yosulib.jnu.ac.kr"><img src="/image/ko/local/globalMenu02.gif" alt="여수캠퍼스도서관"></a></li>
					<li><a href="http://lawlib.jnu.ac.kr"><img src="/image/ko/local/globalMenu03.gif" alt="법학도서관"></a></li>
					<li><a href="http://dentallib.jnu.ac.kr"><img src="/image/ko/local/globalMenu04.gif" alt="치의학도서관"></a></li>
				</ul>
			</div>
			<div class="globalMenu">
				<h2 class="skip">링크메뉴</h2>
				<ul>
					<li class="li txtSize" title="화면크기 조절">
						<a href="javascript:zoomOut();"><img src="/image/ko/local/btnPlus.gif" alt="화면키우기"></a>
						<a href="javascript:zoomIn();"><img src="/image/ko/local/btnMinus.gif" alt="화면줄이기"></a>
                        <a href="javascript:origin();"><img src="/image/ko/local/btnReset.gif" alt="화면크기 원래대로"></a>
                    </li>
					
						
						<li class="li first-child">
					
					<a href="/mainSE" target="_blank" title="새창"><img src="/image/ko/local/glnb02.gif" alt="S"></a></li>
					<li class="li"><a href="/"><img src="/image/ko/local/glnb03.gif" alt="HOME"></a></li>
					
						
							<li class="li"><a href="/login"><img src="/image/ko/local/glnb04.gif" alt="로그인"></a></li>
						
						
					
					<li class="li"><a href="http://www.jnu.ac.kr" target="_blank"><img src="/image/ko/local/glnb05.gif" alt="전남대"></a></li>
					
						<li class="li lag"><a href="/en"><img src="/image/ko/local/glnbEng.gif" alt="ENG"></a></li><li class="li"><a href="/zh"><img src="/image/ko/local/glnbChn.gif" alt="CHN"></a></li>
						
						
					
				</ul>
			</div>
		</div>
		<!-- //divGlobalMenu -->
		
		<div class="staff">
			<ul>
				<li><a href="http://lian.jnu.ac.kr/bms/login.html?user_id=" target="_blank" title="새창">도서관업무관리(BMS)</a></li>
				<li><a href="http://lian.jnu.ac.kr/intranet/annex_admin.php" target="_blank" title="새창">보존서고신청관리</a></li>
				<li><a href="http://lian.jnu.ac.kr/intranet/inven_check.php" target="_blank" title="새창">소장정보관리</a>
					<ul>
						<li><a href="http://lian.jnu.ac.kr/intranet/inven_check.php" target="_blank" title="새창">자료변동내역</a></li>
						<li><a href="http://lian.jnu.ac.kr/intranet/annexdata_save.php" target="_blank" title="새창">보존자료번호수정/입력</a></li>
						<li><a href="http://lian.jnu.ac.kr/intranet/loan_history.html" target="_blank" title="새창">도서 대출이력조회</a></li>
					</ul>
				</li>
				<li><a href="http://lian.jnu.ac.kr/intranet/sjob_man.php" target="_blank" title="새창">근로장학생관리</a></li>
				<li><a href="http://lian.jnu.ac.kr/intranet/userinfo.php" target="_blank" title="새창">도서관이용자조회</a></li>
				<li><a href="http://lib.jnu.ac.kr:90/poll/list" target="_blank" title="새창">도서관설문관리</a></li>
				<li><a href="http://lian.jnu.ac.kr/intranet/lib_statics.php" target="_blank" title="새창">도서관경영통계서비스</a></li>
				<li><a href="http://168.131.53.97:15000/tulip/install.html" target="_blank" title="새창">도서관LAS설치</a></li>
				<li><a href="http://chips.jnu.ac.kr/intranet/homepage_static.php" target="_blank" title="새창">홈페이지접속통계</a></li>
				<li><a href="http://lian.jnu.ac.kr/intranet/onref_man.php" target="_blank" title="새창">외부정보원관리</a></li>
				<li><a href="http://lian.jnu.ac.kr/intranet/dds_local/dds_local_nes.php" target="_blank" title="새창">원문복사비용관리</a></li>
				<li><a href="http://sm.uxbuilder.co.kr" target="_blank" title="새창">IPTV컨텐츠관리</a></li>
				<li><a href="http://www.paoin.com/DID/Default.aspx" target="_blank" title="새창">전자신문(DID)공지관리</a></li>
				<li><a href="http://lian.jnu.ac.kr/intranet/gallery/gallery_main.html" target="_blank" title="새창">갤러리 관리</a></li>
				<li><a href="http://lian.jnu.ac.kr/intranet/picture_info.php" target="_blank" title="새창">도서관사진자료실</a></li>
				<li><a href="http://dcollection.jnu.ac.kr/jsp/4ad.jsp" target="_blank" title="새창">dCollection Admin</a></li>
				<li><a href="http://lian.jnu.ac.kr/intranet/pcpc.php" target="_blank" title="새창">PC보안점검 등록</a></li>
				<li><a href="http://lib.jnu.ac.kr:90" target="_blank" title="새창">홈페이지관리시스템</a></li>
			</ul>
		</div>
		<!-- //STAFF -->
		<hr>
		<h2 class="skip">주메뉴</h2>
  		<div id="divTopMenu">
			<ul id="topmenu">	
				
							
						<li class="gnbDep01 menu1">
							
	                            <a href="http://primo.kesli.or.kr/primo_library/libweb/action/search.do?mode=Basic&vid=CNNU&tab=remote_tab" target="_blank">
	                            
	                        
							<img src="/image/ko/local/gnbC01Out.gif" class="dp01" alt="자료검색"></a>
							<div class="subMenu">
								<ul>
									 
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        <a href="http://primo.kesli.or.kr/primo_library/libweb/action/search.do?mode=Basic&vid=CNNU&tab=remote_tab" target="_blank">통합검색(Discovery)</a>
				                                        
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                <a href="http://primo.kesli.or.kr/primo_library/libweb/action/search.do?mode=Basic&vid=CNNU&tab=remote_tab" target="_blank">통합검색</a>
						                                                
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/search/tot">소장자료검색</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/search/tot">소장자료</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/searchWeb">Open API</a>
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/search/sez?st=FRNT">연속간행물검색</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/search/sez?st=FRNT">기본검색</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/searchA/sez?st=FRNT">A-Z</a>
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
	                       				 
	                            			
											
				                               <li>
				                                    
				                                    
				                                    <a href="/newarrival">신착자료검색</a>
				                                
				                                </li>
				                            
										
									
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/search/maz">비도서검색</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/search/maz">전체</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/search/dvz">DVD</a>
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/search/obz">고문헌검색</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/search/obz">고문헌검색</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/search0101">송광사 고문헌검색</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/search0102">계당 고문헌 검색</a>
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
	                       				 
	                            			
											
				                               <li>
				                                    
				                                    <a href="/relation/ssoDcol" target="_blank">학위논문검색</a>
				                                    
				                                
				                                </li>
				                            
										
									
								</ul>
							</div>
						</li>
					
				
							
						<li class="gnbDep01 menu2">
							
	                            
	                            <a href="/local/html/eResource0101">
	                        
							<img src="/image/ko/local/gnbC02Out.gif" class="dp01" alt="전자자료"></a>
							<div class="subMenu">
								<ul>
									 
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/local/html/eResource0101">학술DB</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/eResource0101">국내학술DB</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/eResource0102">국외학술DB</a>
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
	                       				 
	                            			
											
				                               <li>
				                                    
				                                    
				                                    <a href="/local/html/eResource02">eBook</a>
				                                
				                                </li>
				                            
										
									
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/search/joz?st=FRNT">e-Journal(AtoZ)</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/search/joz?st=FRNT">기본검색</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/searchA/joz?st=FRNT">A-Z</a>
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
								</ul>
							</div>
						</li>
					
				
							
						<li class="gnbDep01 menu3">
							
	                            
	                            <a href="/local/html/service0101">
	                        
							<img src="/image/ko/local/gnbC03Out.gif" class="dp01" alt="도서관서비스"></a>
							<div class="subMenu">
								<ul>
									 
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/local/html/service0101">대출반납서비스</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/service0101">이용안내</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/myloan/list">대출/연장/이력/예약</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/statistics/loanBestList">대출도서순위조회</a>
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/purchaserequest/write">도서신청서비스</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/purchaserequest/write">희망도서신청</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/service020201">보존서고자료</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/service020301">서가부재도서</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/service020401">분관대출조회</a>
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/local/html/service030101">시설이용서비스</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/service030101">스터디룸예약</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                <a href="http://168.131.61.20/EZ5500/RoomStatus/room_status.asp" target="_blank">일반열람실좌석조회</a>
						                                                
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/local/html/service0401">타기관이용서비스</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/service0401">상호대차/원문복사</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/service040201">타기관열람신청</a>
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/local/html/service0501">학위논문파일 제출</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/service0501">학위논문제출안내</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                <a href="/relation/ssoDcol" target="_blank">학위논문제출</a>
						                                                
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/mylibrary/main">개인정보관리</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/mylibrary/main">My Page</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/mylist/list">나의서재</a>
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
								</ul>
							</div>
						</li>
					
				
							
						<li class="gnbDep01 menu4">
							
	                            
	                            <a href="/local/html/edu0101">
	                        
							<img src="/image/ko/local/gnbC04Out.gif" class="dp01" alt="교육연구지원"></a>
							<div class="subMenu">
								<ul>
									 
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/local/html/edu0101">연구지원서비스</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/edu0101">이용안내</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/asklib/write?mId=104000120">서비스신청</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/asklib/list?mId=104000130">신청내역조회</a>
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/local/html/edu0201">이용교육서비스</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/edu0201">교육안내</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/education/list">교육공지 및 신청</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/education/applyList">신청내역조회</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/bbs/list/17">교육자료실</a>
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/local/html/edu0301">배달서비스</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/edu0301">이용안내</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/delivery/list">신청내역조회</a>
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/local/html/edu0401">지정도서신청</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/edu0401">이용안내</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/asklib/write?mId=104000120">신청</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/asklib/list?mId=104000130">신청내역조회</a>
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/local/html/edu0501">논문작성지원</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/edu0501">EndNote 이용</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/edu050201">Turnitin(논문표절예방)이용</a>
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
								</ul>
							</div>
						</li>
					
				
							
						<li class="gnbDep01 menu5">
							
	                            
	                            <a href="/local/html/useInfo0101">
	                        
							<img src="/image/ko/local/gnbC05Out.gif" class="dp01" alt="도서관안내"></a>
							<div class="subMenu">
								<ul>
									 
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/local/html/useInfo0101">도서관소개</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/useInfo0101">연혁</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/useInfo0102">규정</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/useInfo0103">역대관장</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/useInfo0104">조직도</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/useInfo0105">도서관사람들</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/useInfo010601">도서관 통계</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/useInfo0107">찾아오는길</a>
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/local/html/useInfo0201">이용안내</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/useInfo0201">개관시간</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/useInfo0202">자료분류체계</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/useInfo020301">자료이용안내</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/useInfo020401">이용자별안내</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                <a href="http://portal.jnu.ac.kr/Helpdesk/MobileCard/Information/default.aspx?link=http://sccs.jnu.ac.kr/mobi/guide/guide_01.asp" target="_blank">모바일 학생증</a>
						                                                
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/local/html/useInfo030101">시설안내</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/useInfo030101">본관(홍도)안내</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/useInfo0302">별관(백도)안내</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/useInfo030301">분관안내</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/useInfo030401">지원시설</a>
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/local/html/useInfo0401">도서기증/위탁</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/useInfo0401">도서기증 및 위탁안내</a>
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
								</ul>
							</div>
						</li>
					
				
							
						<li class="gnbDep01 menu6">
							
	                            
	                            <a href="/bbs/list/1">
	                        
							<img src="/image/ko/local/gnbC06Out.gif" class="dp01" alt="커뮤니티"></a>
							<div class="subMenu">
								<ul>
									 
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/bbs/list/1">게시판</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/bbs/list/1">공지사항</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/bbs/list/2">학술공지</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/bbs/list/3">질의응답</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/bbs/list/4">건의사항</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/bbs/list/5">분실물안내</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/bbs/list/6">자료실</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/local/html/faq">FAQ</a>
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
	                       				 
	                            			
												<li class="dep02">
													
														
				                                        
				                                        <a href="/poll/main">참여마당</a>
				                                    
													<ul>
														
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/poll/main">설문조사</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/iframe/recomRelay?url=http://lian.jnu.ac.kr/intranet/user_note.php?note_id=책추천릴레이">책 추천릴레이</a>
						                                            
						                                        </li>
					                                        
				                                        
					                                       	
						                                        <li>
						                                                
						                                                
						                                                <a href="/iframe/recomRelay?url=http://lian.jnu.ac.kr/intranet/gallery/gallery_body.html">도서관 Gallery</a>
						                                            
						                                        </li>
					                                        
				                                        
													</ul>
												</li>
											
											
										
									
								</ul>
							</div>
						</li>
					
				
					
				
			</ul>
			<!-- //topmenu -->
            <p class="allmenu" id="open_mOverview"><a href="#mOverview"><img src="/image/ko/local/allMenu.gif" alt="전체메뉴"></a></p>
            <div id="mOverview">
            	<span class="close_mOverview"><a href="#" ><img src="/image/ko/local/btnClose.gif" alt="닫기"></a></span> 
                <ul class="allMenuView">
                	
						
							<li>
							
	                            <a href="http://primo.kesli.or.kr/primo_library/libweb/action/search.do?mode=Basic&vid=CNNU&tab=remote_tab" target="_blank">
	                            
	                        
							<img src="/image/ko/local/allnavC01.gif" alt="자료검색"></a>
							 	<div class="allsm">
							 		<ul>
							 			
		                               		
		                               			
			                                          <li>
			                                                
			                                                <a href="http://primo.kesli.or.kr/primo_library/libweb/action/search.do?mode=Basic&vid=CNNU&tab=remote_tab" target="_blank">통합검색(Discovery)</a>
			                                                
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/search/tot">소장자료검색</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/search/sez?st=FRNT">연속간행물검색</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
		                               		
		                               			
			                                    
			                                       <li>
			                                            
			                                            <a href="/newarrival">신착자료검색</a>
			                                        
			                                        </li>
			                                    
		                               		
			                            
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/search/maz">비도서검색</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/search/obz">고문헌검색</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
		                               		
		                               			
			                                    
			                                       <li>
			                                            <a href="/relation/ssoDcol" target="_blank">학위논문검색</a>
			                                            
			                                        
			                                        </li>
			                                    
		                               		
			                            
							 		</ul>
							 	</div>
							 </li>
						
					
						
							<li>
							
	                            
	                            <a href="/local/html/eResource0101">
	                        
							<img src="/image/ko/local/allnavC02.gif" alt="전자자료"></a>
							 	<div class="allsm">
							 		<ul>
							 			
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/local/html/eResource0101">학술DB</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
		                               		
		                               			
			                                    
			                                       <li>
			                                            
			                                            <a href="/local/html/eResource02">eBook</a>
			                                        
			                                        </li>
			                                    
		                               		
			                            
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/search/joz?st=FRNT">e-Journal(AtoZ)</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
							 		</ul>
							 	</div>
							 </li>
						
					
						
							<li>
							
	                            
	                            <a href="/local/html/service0101">
	                        
							<img src="/image/ko/local/allnavC03.gif" alt="도서관서비스"></a>
							 	<div class="allsm">
							 		<ul>
							 			
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/local/html/service0101">대출반납서비스</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/purchaserequest/write">도서신청서비스</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/local/html/service030101">시설이용서비스</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/local/html/service0401">타기관이용서비스</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/local/html/service0501">학위논문파일 제출</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/mylibrary/main">개인정보관리</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
							 		</ul>
							 	</div>
							 </li>
						
					
						
							<li>
							
	                            
	                            <a href="/local/html/edu0101">
	                        
							<img src="/image/ko/local/allnavC04.gif" alt="교육연구지원"></a>
							 	<div class="allsm">
							 		<ul>
							 			
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/local/html/edu0101">연구지원서비스</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/local/html/edu0201">이용교육서비스</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/local/html/edu0301">배달서비스</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/local/html/edu0401">지정도서신청</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/local/html/edu0501">논문작성지원</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
							 		</ul>
							 	</div>
							 </li>
						
					
						
							<li>
							
	                            
	                            <a href="/local/html/useInfo0101">
	                        
							<img src="/image/ko/local/allnavC05.gif" alt="도서관안내"></a>
							 	<div class="allsm">
							 		<ul>
							 			
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/local/html/useInfo0101">도서관소개</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/local/html/useInfo0201">이용안내</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/local/html/useInfo030101">시설안내</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/local/html/useInfo0401">도서기증/위탁</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
							 		</ul>
							 	</div>
							 </li>
						
					
						
							<li>
							
	                            
	                            <a href="/bbs/list/1">
	                        
							<img src="/image/ko/local/allnavC06.gif" alt="커뮤니티"></a>
							 	<div class="allsm">
							 		<ul>
							 			
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/bbs/list/1">게시판</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
		                               		
		                               			
			                                          <li>
			                                                
			                                                
			                                                <a href="/poll/main">참여마당</a>
			                                             
			                                          </li>
			                                    
			                                    
		                               		
			                            
							 		</ul>
							 	</div>
							 </li>
						
					
						
					             
                </ul>
            </div>
		</div>
		<!-- //divTopMenu -->
        <noscript>
        	<div class="noscriptMenu">
               <ul class="allMenuView">
               	 	
						
							<li>
							
	                            <a href="http://primo.kesli.or.kr/primo_library/libweb/action/search.do?mode=Basic&vid=CNNU&tab=remote_tab" target="_blank">
	                            
	                        
							<img src="/image/ko/local/allnavC01.gif" alt="자료검색"></a>
								<div class="allsm">
	                                <ul>
	                                	
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                <a href="http://primo.kesli.or.kr/primo_library/libweb/action/search.do?mode=Basic&vid=CNNU&tab=remote_tab" target="_blank">통합검색(Discovery)</a>
			                                                
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/search/tot">소장자료검색</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/search/sez?st=FRNT">연속간행물검색</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
			                                
			                                    
			                                    
			                                       <li>
			                                            
			                                            <a href="/newarrival">신착자료검색</a>
			                                        
			                                        </li>
			                                    
			                                
			                            
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/search/maz">비도서검색</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/search/obz">고문헌검색</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
			                                
			                                    
			                                    
			                                       <li>
			                                            <a href="/relation/ssoDcol" target="_blank">학위논문검색</a>
			                                            
			                                        
			                                        </li>
			                                    
			                                
			                            
	                                </ul>
                                </div>
							</li>
						
					
						
							<li>
							
	                            
	                            <a href="/local/html/eResource0101">
	                        
							<img src="/image/ko/local/allnavC02.gif" alt="전자자료"></a>
								<div class="allsm">
	                                <ul>
	                                	
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/local/html/eResource0101">학술DB</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
			                                
			                                    
			                                    
			                                       <li>
			                                            
			                                            <a href="/local/html/eResource02">eBook</a>
			                                        
			                                        </li>
			                                    
			                                
			                            
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/search/joz?st=FRNT">e-Journal(AtoZ)</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
	                                </ul>
                                </div>
							</li>
						
					
						
							<li>
							
	                            
	                            <a href="/local/html/service0101">
	                        
							<img src="/image/ko/local/allnavC03.gif" alt="도서관서비스"></a>
								<div class="allsm">
	                                <ul>
	                                	
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/local/html/service0101">대출반납서비스</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/purchaserequest/write">도서신청서비스</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/local/html/service030101">시설이용서비스</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/local/html/service0401">타기관이용서비스</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/local/html/service0501">학위논문파일 제출</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/mylibrary/main">개인정보관리</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
	                                </ul>
                                </div>
							</li>
						
					
						
							<li>
							
	                            
	                            <a href="/local/html/edu0101">
	                        
							<img src="/image/ko/local/allnavC04.gif" alt="교육연구지원"></a>
								<div class="allsm">
	                                <ul>
	                                	
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/local/html/edu0101">연구지원서비스</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/local/html/edu0201">이용교육서비스</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/local/html/edu0301">배달서비스</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/local/html/edu0401">지정도서신청</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/local/html/edu0501">논문작성지원</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
	                                </ul>
                                </div>
							</li>
						
					
						
							<li>
							
	                            
	                            <a href="/local/html/useInfo0101">
	                        
							<img src="/image/ko/local/allnavC05.gif" alt="도서관안내"></a>
								<div class="allsm">
	                                <ul>
	                                	
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/local/html/useInfo0101">도서관소개</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/local/html/useInfo0201">이용안내</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/local/html/useInfo030101">시설안내</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/local/html/useInfo0401">도서기증/위탁</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
	                                </ul>
                                </div>
							</li>
						
					
						
							<li>
							
	                            
	                            <a href="/bbs/list/1">
	                        
							<img src="/image/ko/local/allnavC06.gif" alt="커뮤니티"></a>
								<div class="allsm">
	                                <ul>
	                                	
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/bbs/list/1">게시판</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
			                                
			                                    
			                                    	<li>
			                                    		
			                                                
			                                                
			                                                <a href="/poll/main">참여마당</a>
			                                            
			                                        </li>
			                                    
			                                    
			                                
			                            
	                                </ul>
                                </div>
							</li>
						
					
						
					
                </ul>
            </div>
        </noscript>
	</div>
<hr>
		<div id="divContents">
			<div id="divContentW"> 
				<div id="divLocation">
					<ul>
						<li><a href="/"><img src="/image/ko/local/icoHome.png" alt="홈" title="홈"></a></li>
						<li></li>
						
					</ul>
				</div>
				<div id="divTitle">
					<h2 class="skip"></h2>
		            <h3 class="titleStyle"></h3>
		        </div>
				
           
				<script language="javascript">
function oncookie()
{
	alert(document.cookie);
}
</script>




   
   

<script>
	location.href="/tulip/jsp/theme/chonnam/sslReturn.jsp?uid=NzA1NTY=&goPage=/myloan/list";
</script>
			</div>
				<div id="divSideBar" class="quickmenu">
				 	 <!-- divQuick start -->
					 
<div id="divQuick">
	<h2><img src="/image/ko/local/quickTitle.gif" alt="QUICK LINK"></h2>            	
    <ul>
        <li><a href="/purchaserequest/write"><img src="/image/ko/local/quickMenu1.gif" alt="희망도서신청" title="희망도서신청"></a></li>
        <li><a href="/myloan/list"><img src="/image/ko/local/quickMenu2.gif" alt="대출/연장조회" title="대출/연장조회"></a></li>
        <li><a href="/missrepo/list"><img src="/image/ko/local/quickMenu3.gif" alt="서가부재도서" title="서가부재도서"></a></li>
        <li class="last-child"><a href="/education/list"><img src="/image/ko/local/quickMenu5.gif" alt="이용교육" title="이용교육"></a></li>
    </ul>
</div>     
					 <!-- divQuick end -->
					 <!-- divMyMenu start -->
					 
<div id="divMyMenu">
	
	
            	<h2><a href="/mymenu/insert/?retUrl=/tulip/jsp/theme/chonnam/logon.jsp?from_url=%2fmyloan%2flist" onclick="return confirm('현재 페이지를 메뉴에 추가 하시겠습니까?');"><img src="/image/ko//local/myMenuTitle.gif" alt="마이메뉴추가"></a></h2>
                <div class="myMenu">
                    <ul>
                    	
					    	
                    </ul>
                </div>
            </div>
					 <!-- divMyMenu end -->
				 </div>
		</div>
	<hr>
	<div id="divFooter">
		<div class="divFooterBox">
			

	<div class="divFoot1">
		<div class="QRcode"><img src="/image/ko/local/qrCode.png" alt="QRCode" /></div>
		<div class="footerLogo"><img src="/image/ko/local/logoFooter.gif" alt="전남대학교중앙도서관" /></div>
	</div>
	<div class="divFoot2">
		<div class="footerInfo">
			<ul>
				<li class="first-child"><a href="http://www.jnu.ac.kr/MainGuide/Policy/Protection.aspx" target="_blank" title="새창"><img src="/image/ko/local/footLink01.gif" alt="개인정보호정책" /></a></li>
				<li><a href="http://www.jnu.ac.kr/MainGuide/Rejection/Rejection.aspx" target="_blank" title="새창"><img src="/image/ko/local/footLink02.gif" alt="이메일무단수집거부" /></a></li>
				<li><a href="/bbs/list/3"><img src="/image/ko/local/footLink03.gif" alt="도서관이용문의" /></a></li>
				<li class="pt1"><a href="http://dojawi.jnu.ac.kr" target="_blank" title="새창"><img src="/image/ko/local/footLink04.gif" alt="도서관자치위원회" /></a></li>
				
				<li class="last-child">
					<a href="http://www.facebook.com/jnulib" class="fb" target="_blank"><img src="/image/ko/local/icoFacebook.gif" alt="facebook" /></a>
					<a href="http://cnulib.tistory.com" target="_blank" title="새창"><img src="/image/ko/local/icoW.gif" alt="w" /></a>
				</li>
			</ul>
		</div>
		<div class="address"><img src="/image/ko/local/address.gif" alt="500-757 광주광역시 북구 용봉로 77   TEL  062)530-3571~2(대출반납실)   FAX  062)530-3529" /></div>
		<div class="copyright"><img src="/image/ko/local/copyright.gif" alt="Copyright@2013 CHONNAM NATIONAL UNIVERSITY LIBRARY, All Rights Reserved. " /></div>
	</div>
	<div class="divFoot3">
		<div class="visitor">
			<ul>
				<li class="today" title="today">3956</li><!-- 12.26일자 총카운트 1174922 -->
				<li class="total" title="total">1546235</li>
			</ul>
		</div>
		<div class="site">
<!-- 			<h2>관련사이트</h2> -->
			<select class="link1" id="selectRelatedSites1" name="member">
				<option value="">국내외 도서관</option>
				<option value="http://libproxy.jnu.ac.kr/_Lib_Proxy_Url/www.riss.kr/OrganLogin.do">RISS-한국교육학술정보원</option>
				<option value="http://www.lg.or.kr?">LG 상남도서관</option>
				<option value="http://library.cuk.ac.kr?">가톨릭대학교 도서관</option>
				<option value="http://lib.kangnam.ac.kr?">강남대학교 도서관</option>
				<option value="http://iskul.kangnung.ac.kr?">강릉대학교 도서관</option>
				<option value="http://dli.kangwon.ac.kr?">강원대학교 삼척캠퍼스 도서관</option>
				<option value="http://library.kangwon.ac.kr?">강원대학교 중앙도서관</option>
				<option value="http://kkul.konkuk.ac.kr?">건국대학교 상허기념도서관</option>
				<option value="http://library.kyonggi.ac.kr?">경기대학교 중앙도서관</option>
				<option value="http://cjlib.chinju.ac.kr?">경남과학기술대학교 도서관</option>
				<option value="http://library.kyungnam.ac.kr?">경남대학교 중앙도서관</option>
				<option value="http://kudos.knu.ac.kr?">경북대학교 도서관</option>
				<option value="http://library.gnu.ac.kr?">경상대학교 중앙도서관</option>
				<option value="http://library.ks.ac.kr?">경성대학교 중앙도서관</option>
				<option value="http://lib.ginue.ac.kr?">경인교육대학교 도서관</option>
				<option value="http://khis.kyunghee.ac.kr?">경희대학교 도서관</option>
				<option value="http://kimsweb.keimyung.ac.kr?">계명대학교 동산도서관</option>
				<option value="http://library.korea.ac.kr?">고려대학교 중앙도서관</option>
				<option value="http://library.kosin.ac.kr?">고신대학교 중앙도서관</option>
				<option value="http://lib.gjue.ac.kr?">공주교육대학교 디지털도서관</option>
				<option value="http://library.kongju.ac.kr?">공주대학교 중앙도서관</option>
				<option value="http://library.kd.ac.kr?">관동대학교 중앙도서관</option>
				<option value="http://kupis.kwangwoon.ac.kr?">광운대학교 중앙도서관</option>
				<option value="http://library.kjist.ac.kr?">광주과학기술원 도서관</option>
				<option value="http://library.gnue.ac.kr?">광주교육대학교 디지털도서관</option>
				<option value="http://klic.kwangju.ac.kr?">광주대학교 중앙도서관</option>
				<option value="http://www.dlibrary.go.kr?">국가전자도서관</option>
				<option value="http://www.nl.go.kr?">국립중앙도서관</option>
				<option value="http://lib.kookmin.ac.kr?">국민대학교 성곡도서관</option>
				<option value="http://www.nanet.go.kr?">국회도서관</option>
				<option value="http://library.kunsan.ac.kr?">군산대학교 중앙도서관</option>
				<option value="http://library.kumoh.ac.kr?">금오공과대학교 도서관</option>
				<option value="http://nsulib.nsu.ac.kr?">남서울대학교 중앙도서관</option>
				<option value="http://203.237.217.5?">단국대학교 율곡기념도서관</option>
				<option value="http://lib.dankook.ac.kr?">단국대학교 퇴계기념중앙도서관</option>
				<option value="http://lib.cu.ac.kr?">대구가톨릭대학교 중앙도서관</option>
				<option value="http://discover.duksung.ac.kr?">덕성여자대학교 중앙도서관</option>
				<option value="http://lib.dongguk.edu?">동국대학교 도서관</option>
				<option value="http://210.121.133.152?">동덕여자대학교 중앙도서관</option>
				<option value="http://lib.dsu.ac.kr?">동신대학교 중앙도서관</option>
				<option value="http://av3600.donga.ac.kr?">동아대학교 중앙도서관</option>
				<option value="http://lib.deu.ac.kr?">동의대학교 중앙도서관</option>
				<option value="http://lib.mju.ac.kr?">명지대학교 도서관</option>
				<option value="http://lib.mokwon.ac.kr?">목원대학교 중앙도서관</option>
				<option value="http://library.mokpo.ac.kr?">목포대학교 중앙도서관</option>
				<option value="http://library.paichai.ac.kr?">배재대학교 중앙도서관</option>
				<option value="http://libweb.pknu.ac.kr?">부경대학교 도서관</option>
				<option value="http://library.bnue.ac.kr?">부산교육대학교 학술정보관</option>
				<option value="http://pulip.pusan.ac.kr?">부산대학교 도서관</option>
				<option value="http://library.pufs.ac.kr?">부산외국어대학교 도서관</option>
				<option value="http://lib.syu.ac.kr?">삼육대학교 도서관</option>
				<option value="http://lib.smu.ac.kr?">상명대학교 중앙도서관</option>
				<option value="http://library.sangji.ac.kr?">상지대학교 학술정보원</option>
				<option value="http://library.sogang.ac.kr?">서강대학교 로욜라도서관</option>
				<option value="http://library.seoultech.ac.kr/?">서울과학기술대학교 도서관</option>
				<option value="http://www.lib.snue.ac.kr?">서울교육대학교 디지털도서관</option>
				<option value="http://aglib.snu.ac.kr?">서울대학교 농학도서관</option>
				<option value="http://sociallib.snu.ac.kr?">서울대학교 사회과학도서관</option>
				<option value="http://library.snu.ac.kr?">서울대학교 중앙도서관</option>
				<option value="http://library.uos.ac.kr?">서울시립대학교 중앙도서관</option>
				<option value="http://www.stuin.ac.kr?">서울신학대학교 도서관</option>
				<option value="http://lib.swu.ac.kr?">서울여자대학교 중앙도서관</option>
				<option value="http://lib.seowon.ac.kr?">서원대학교 학술정보원</option>
				<option value="http://library.sungkyul.ac.kr?">성결대학교 학술정보관</option>
				<option value="http://library.skhu.ac.kr?">성공회대학교 중앙도서관</option>
				<option value="http://lib.skku.edu?">성균관대학교 학술정보관</option>
				<option value="http://lib.sungshin.ac.kr?">성신여자대학교 중앙도서관</option>
				<option value="http://library.sejong.ac.kr?">세종대학교 학술정보원</option>
				<option value="http://mathnet.kaist.ac.kr?">수리과학연구정보센터</option>
				<option value="http://lib.suwon.ac.kr?">수원대학교 중앙도서관</option>
				<option value="http://lib.sookmyung.ac.kr?">숙명여자대학교 도서관</option>
				<option value="http://library.sunchon.ac.kr?">순천대학교 중앙도서관</option>
				<option value="http://library.sch.ac.kr?">순천향대학교 향설기념 중앙도서관</option>
				<option value="http://oasis.soongsil.ac.kr?">숭실대학교 중앙도서관</option>
				<option value="http://library.silla.ac.kr?">신라대학교 도서관</option>
				<option value="http://library.ajou.ac.kr?">아주대학교 중앙도서관</option>
				<option value="http://lib.andong.ac.kr?">안동대학교 중앙도서관</option>
				<option value="http://ymlib.yonsei.ac.kr?">연세대학교 의학도서관</option>
				<option value="http://library.yonsei.ac.kr?">연세대학교 학술정보원</option>
				<option value="http://libs.yeungnam.ac.kr?">영남대학교 중앙도서관</option>
				<option value="http://yulis.youngdong.ac.kr?">영동대학교 중앙도서관</option>
				<option value="http://library.woosuk.ac.kr?">우석대학교 중앙도서관</option>
				<option value="http://library.ulsan.ac.kr?">울산대학교 중앙도서관</option>
				<option value="http://elibrary.wonkwang.ac.kr?">원광대학교 중앙도서관</option>
				<option value="http://www.wolgyelib.kr?">월계문화정보도서관</option>
				<option value="http://lib.uiduk.ac.kr?">위덕대학교 회당학술정보원</option>
				<option value="http://lib.ewha.ac.kr?">이화여자대학교 중앙도서관</option>
				<option value="http://library.induk.ac.kr?">인덕대학 도서관</option>
				<option value="http://ilis1.inje.ac.kr?">인제대학교 백인제기념도서관</option>
				<option value="http://lib.inchon.ac.kr?">인천대학교 학산도서관</option>
				<option value="http://library.inha.ac.kr?">인하대학교 정석학술정보관</option>
				<option value="http://library.pcts.ac.kr?">장로회신학대학교 도서관</option>
				<option value="http://yosulib.chonnam.ac.kr?">전남대학교 여수캠퍼스 도서관</option>
				<option value="http://dl.chonbuk.ac.kr?">전북대학교 중앙도서관</option>
				<option value="http://lib.jnue.ac.kr?">전주교육대학교 디지털도서관</option>
				<option value="http://lib.jj.ac.kr?">전주대학교 중앙도서관</option>
				<option value="http://chulic.cheju.ac.kr?">제주대학교 중앙도서관</option>
				<option value="http://library.chosun.ac.kr?">조선대학교 중앙도서관</option>
				<option value="http://library.cau.ac.kr?">중앙대학교 서울캠퍼스 중앙도서관</option>
				<option value="http://alibrary.cau.ac.kr?">중앙대학교 안성캠퍼스 중앙도서관</option>
				<option value="http://lib.cue.ac.kr?">진주교육대학교 도서관</option>
				<option value="http://lib.changwon.ac.kr?">창원대학교 중앙도서관</option>
				<option value="http://wuam.chongju.ac.kr?">청주대학교 중앙도서관</option>
				<option value="http://library.chugye.ac.kr?">추계예술대학교 전자정보도서관</option>
				<option value="http://clins.cnu.ac.kr?">충남대학교 디지털도서관</option>
				<option value="http://cbnul.chungbuk.ac.kr?">충북대학교 도서관</option>
				<option value="http://library.postech.ac.kr?">포항공과대학교 청암학술정보관</option>
				<option value="http://library.kaist.ac.kr?">한국과학기술원 전자도서관</option>
				<option value="http://libsvr.knue.ac.kr?">한국교원대학교 도서관</option>
				<option value="http://dasan.kut.ac.kr?">한국기술교육대학교 다산정보관</option>
				<option value="http://weblib.hufs.ac.kr?">한국외국어대학교 도서관</option>
				<option value="http://library.knsu.ac.kr?">한국체육대학교 학술정보시스템</option>
				<option value="http://library.hhu.ac.kr?">한국해양대학교 도서관</option>
				<option value="http://hanul.hannam.ac.kr?">한남대학교 학술정보관</option>
				<option value="http://library.handong.edu?">한동대학교 학술정보관</option>
				<option value="http://library.hallym.ac.kr?">한림대학교 일송기념도서관</option>
				<option value="http://lib.hanbat.ac.kr?">한밭대학교 도서관</option>
				<option value="http://library.hanseo.ac.kr?">한서대학교 중앙도서관</option>
				<option value="http://hsel.hansung.ac.kr?">한성대학교 학술정보관</option>
				<option value="http://library.hanyang.ac.kr?">한양대학교 백남학술정보관</option>
				<option value="http://information.hanyang.ac.kr?">한양대학교 안산학술정보관</option>
				<option value="http://library.honam.ac.kr?">호남대학교 중앙도서관</option>
				<option value="http://honors.hongik.ac.kr?">홍익대학교 중앙도서관</option>
				<option value="http://www.cnumlib.or.kr?">화순전남대병원의학도서실</option>
			</select>
			<select class="link2" id="selectRelatedSites2" name="member">
				<option value="">온라인참고 정보</option>
				<option value="http://libproxy.jnu.ac.kr/_Lib_Proxy_Url/www.riss.kr/OrganLogin.do">RISS-한국교육학술정보원</option>
				<option value="http://www.ndsl.kr?">NDSL 과학기술정보통합서비스</option>
				<option value="http://www.auric.or.kr/?">건설연구정보센터(서울대학교)</option>
				<option value="http://www.stepi.re.kr?">과학기술정책연구원(STEPI)</option>
				<option value="http://www.kjist.ac.kr?">광주과학기술원(K-JIST)</option>
				<option value="http://kmbase.medric.or.kr?">국내의학학술지 초록검색</option>
				<option value="www.metric.or.kr?">기계공학연구정보센터(부산대학교)</option>
				<option value="http://www.alric.org?">농생명과학연구정보센터(서울대학교)</option>
				<option value="http://www.kiep.go.kr?">대외경제정책연구원(KIEP)</option>
				<option value="http://icpr.snu.ac.kr?">물리학연구정보센터(서울대학교)</option>
				<option value="http://www.richis.org?">보건연구정보센터(전남대학교)</option>
				<option value="http://bric.postech.ac.kr?">생물학연구정보센터(포항공과대학교)</option>
				<option value="http://sdic.sookmyung.ac.kr?">의약연구정보센터(숙명여자대학교)</option>
				<option value="http://www.medric.or.kr?">의학연구정보센터(충북대학교)</option>
				<option value="http://www.icm.re.kr?">재료연구정보센터(경북대학교)</option>
				<option value="http://cimerr.postech.ac.kr?">테크노경영연구정보센터</option>
				<option value="http://www.kist.re.kr?">한국과학기술연구원(KIST)</option>
				<option value="http://www.kaist.ac.kr?">한국과학기술원(KAIST)</option>
				<option value="http://www.kisti.re.kr?">한국과학기술정보연구원(KISTI)</option>
				<option value="http://www.kedi.re.kr?">한국교육개발원(KEDI)</option>
				<option value="http://www.kimm.re.kr?">한국기계연구원(KIMM)</option>
				<option value="http://www.kbsi.re.kr?">한국기초과학지원연구원(KBSI)</option>
				<option value="http://www.arko.or.kr?">한국문화예술진흥원(KCAF)</option>
				<option value="http://www.kribb.re.kr?">한국생명공학연구원(KRIBB)</option>
				<option value="http://www.kier.re.kr?">한국에너지기술연구원(KIER)</option>
				<option value="http://www.kaeri.re.kr?">한국원자력연구원(KAERI)</option>
				<option value="http://www.keri.re.kr?">한국전기연구원(KERI)</option>
				<option value="http://www.etri.re.kr?">한국전자통신연구원(ETRI)</option>
				<option value="http://www.kigam.re.kr?">한국지질자원연구원(KIGAM)</option>
				<option value="http://www.kriss.re.kr?">한국표준과학연구원(KRISS)</option>
				<option value="http://www.kari.re.kr?">한국항공우주연구원(KARI)</option>
				<option value="http://www.kordi.re.kr?">한국해양연구원(KORDI)</option>
				<option value="http://www.krict.re.kr?">한국화학연구원(KRICT)</option>
				<option value="http://www.kei.re.kr?">한국환경정책평가연구원</option>
				<option value="http://www.cheric.org?">화학공학연구정보센터(고려대학교)</option>
				<option value="http://ysgeo.yonsei.ac.kr?">환경지질연구정보센터(연세대학교)</option>
			</select>
		</div>
	</div>
		</div>
	</div>
</div>
<!-- primo login -->

<!--proxy-->
	
</body>
</html>
