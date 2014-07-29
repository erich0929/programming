<?php
	require ('dbconnection.php');
	$titles = array (
		'Nature always sides with thi hidden flaw',
		'Adding manpower to a late software project makes it later.',
		'Research supports a specific theory depending on the amount of funds dedicated to it.',
		'Always draw your curves, then plot your reading.',
		'Software bugs are hard to detect by anybody except may be the end user.');
	$authors = array (
		'Luke Skywalker', 'Leia Organa', 'Han Solo', 'Darth Vander', 'Spock', 'James Kirk', 'Hikaru Sulu',
		'Nyota Uhura');
	$description = "Lorem ipsum dolor sit amet, consectetur adipisigndf elfit, sed do  eiusmod trempor incididunt ut 
		labore er dore manfa aliqua";
	$categories = array ('Electronics', 'Mathematics', 'Programming', 'Data Structure', 'Alogrithms', 'Computer Networking');
	$tags = array ('project', 'Programming', 'testing', 'webdesign', 'tutorial', 'howto', 'version-control', 'nosql', 'Alogrithms',
		'engineering', 'software', 'harware', 'security');

	function getRandomArrayItem ($array) { 
		$length = count ($array);
		$randomIndex = mt_rand (0, $length - 1);
		return $array [$randomIndex];
	}

	function getRandomTimestamp () {
		$randomDigit = mt_rand (0, 6) * -1;
		return strtotime ($randomDigit . ' day');
	}

	function createDoc () {
		global $titles, $authors, $categories, $tags;
		$title = getRandomArrayItem ($titles);
		$author = getRandomArrayItem ($authors);
		$category = getRandomArrayItem ($categories);
		$articleTags = array ();
		$numOfTags = rand (1, 5);
		for ($j = 0; $j < $numOfTags; $j++) {
			$tag = getRandomArrayItem ($tags);
			if (!in_array ($tag, $articleTags)) {
				array_push ($articleTags, $tag);
			}
		}
		$rating = mt_rand (1, 10);
		$publishedAt = new MongoDate (getRandomTimestamp ());
		return array ('title' => $title, 'authors' => $author, 'category' => $category,
			'tags' => $tag, 'rating' => $rating, 'publishedAt' => $publishedAt);
	}
	$mongo = DBConnection::instantiate ();
	$collection = $mongo -> getCollection ('sample_articles');
	echo "Generating sample data...\n";
	for ($i = 0; $i < 1000; $i ++) {
		$document = createDoc ();
		$collection -> insert ($document);
		echo "\rGenerating sample data..." . $i . "/" . "1000";
	}
	echo "\rFinished !!                                                 \n";
?>
