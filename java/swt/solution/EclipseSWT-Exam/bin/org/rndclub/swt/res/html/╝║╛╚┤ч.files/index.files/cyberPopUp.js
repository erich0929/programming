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
{	// ������� ����
	var todayDate = new Date(); // ����ð�

	y = todayDate.getYear();
	m = todayDate.getMonth();
	d = todayDate.getDate();

	todayDate = new Date(y,m,d); // ���ó�¥��
	todayDate.setDate( todayDate.getDate() + expiredays ); // ���ó�¥�� ��ȿ���ڸ� ���ϰ�
	document.cookie = name + "=" + escape( value ) + "; path=/; domain=.cyber.co.kr; expires=" + todayDate.toGMTString() + ";"
}
*/
function popUp_setCookie( name, value, expireHours )
{
//	return;// ��Ű�� �����ϸ� ������ ���ܼ� �ϴ� ���� 4/14
	var todayDate = new Date(); // ����ð�
	todayDate.setHours( todayDate.getHours() + expireHours ); // ����ð��� ��ȿ�ð��� ���ϰ�
	cookString = name + "=" + escape( value ) + "; path=/; domain=.cyber.co.kr; expires=" + todayDate.toGMTString() + ";"
	document.cookie = cookString;
}
function popUp_closeWin(html) 
{ 
        if ( document.checkForm.Never.checked ) {
                popUp_setCookie( html, "done" , 5); // 5�ð����� ����â ���� ����
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

	var endDate2 = new Date(temp[0],temp[1]-1,temp[2]); // ��Ʈ���� ��¥Ÿ������ ��ȯ
	var toDay = new Date();
	endDate2.setDate( endDate2.getDate() + 1 ); // ������ ��¥���� �Ϸ� ���� ��¥�� ���ϰ�

//alert(toDay + "\n" + endDate2);
	// 4/16 > 5/3
	if(toDay > endDate2 ) return false; // ��¥�� ��������
	else return true; // ��¥�� ������ �ʾ�����
}
-->

