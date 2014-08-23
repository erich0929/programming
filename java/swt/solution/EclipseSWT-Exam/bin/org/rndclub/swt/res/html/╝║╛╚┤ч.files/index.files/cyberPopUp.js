<!-- 
function GetCookie( name )
{
        var nameOfCookie = name + "=";
        var x = 0;
        while ( x <= document.cookie.length )
        {
                var y = (x+nameOfCookie.length);
                if ( document.cookie.substring( x, y ) == nameOfCookie ) {
                        if ( (endOfCookie=document.cookie.indexOf( ";", y )) == -1 )
                                endOfCookie = document.cookie.length;
                        return unescape( document.cookie.substring( y, endOfCookie ) );
                }
                x = document.cookie.indexOf( " ", x ) + 1;
                if ( x == 0 )
                        break;
        }
        return "";
}
function PopWin( Url, name, Xsize, Ysize, Scroll, xPos, yPos, reSize )
{
  if( Xsize  == null ) Xsize  = 650
  if( Ysize  == null ) Ysize  = 400
  if( Scroll == null ) Scroll = 'yes'
  if( reSize == null ) reSize = 'yes'

  if(yPos == null) yPos = 1;
  if(xPos == null) xPos = 1;
  var opt = "width="+Xsize+",height="+Ysize+",scrollbars="+Scroll+",toolbar=no,location=no,directories=no,status=no,menubar=no,resizable=" + reSize+",copyhistory=yes,top=" + yPos + ",left=" + xPos
  popup = window.open( Url, name, opt);
  popup.focus();

}
/*
function WinCustomer(must)
{
	var name = '20030409002';

	var url;
	if ( must==true || GetCookie( name ) != 'done'  ) {
		url = '/v2/popup/' + name + '.html';
		PopWin(url,name, 300, 400, 'yes', 340 );
	}
}

function popUp_setCookieXXXXXXXXXXX( name, value, expiredays )
{	// 사용하지 않음
	var todayDate = new Date(); // 현재시간

	y = todayDate.getYear();
	m = todayDate.getMonth();
	d = todayDate.getDate();

	todayDate = new Date(y,m,d); // 오늘날짜만
	todayDate.setDate( todayDate.getDate() + expiredays ); // 오늘날짜에 유효일자를 더하고
	document.cookie = name + "=" + escape( value ) + "; path=/; domain=.cyber.co.kr; expires=" + todayDate.toGMTString() + ";"
}
*/
function popUp_setCookie( name, value, expireHours )
{
//	return;// 쿠키를 저장하면 문제가 생겨서 일단 보류 4/14
	var todayDate = new Date(); // 현재시간
	todayDate.setHours( todayDate.getHours() + expireHours ); // 현재시간에 유효시간을 더하고
	cookString = name + "=" + escape( value ) + "; path=/; domain=.cyber.co.kr; expires=" + todayDate.toGMTString() + ";"
	document.cookie = cookString;
}
function popUp_closeWin(html) 
{ 
        if ( document.checkForm.Never.checked ) {
                popUp_setCookie( html, "done" , 5); // 5시간동안 공지창 열지 않음
		}
        self.close(); 
}

function isPast(endDate)
{
	var temp = endDate.split("-");
	if(temp.length !=3) {
		temp[0] = "2099";
		temp[1] = "11";
		temp[2] = "31";
	}

	var endDate2 = new Date(temp[0],temp[1]-1,temp[2]); // 스트링을 날짜타입으로 변환
	var toDay = new Date();
	endDate2.setDate( endDate2.getDate() + 1 ); // 지정된 날짜보다 하루 다음 날짜를 구하고

//alert(toDay + "\n" + endDate2);
	// 4/16 > 5/3
	if(toDay > endDate2 ) return false; // 날짜가 지났으면
	else return true; // 날짜가 지나지 않았으면
}
-->

