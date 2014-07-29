<?php
	$arr = array (1,2,3);
	echo $arr [0] . "\n";
	$copy = $arr; // 얕은 복사.
	$copy [0] = 5;
	echo $arr [0] . "\n";

	class klass {
		public $a = 0;
	}

	$instance = new klass ();
	$cpinstance = $instance;
	$cpinstance -> a = 5;

	echo $instance -> a . "\n";
?>
