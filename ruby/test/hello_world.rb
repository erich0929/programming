string = 
%q{	이름	주소	나이
	김광로	광주	27
	김수혜	광주	25

}

puts string.gsub(/^\s*|\s*$/, '')
