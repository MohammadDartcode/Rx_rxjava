<?php

require_once 'connection.php';

$query = " SELECT * FROM posts ";

$result = mysqli_query($connection,$query);

if($result){
	
	$response = array();
	
	while($row = mysqli_fetch_array($result)){
		
		$posts = array();
		
		$posts['id'] = $row['id'];
		$posts['name'] = $row['name'];
		$posts['location'] = $row['location'];
		$posts['link_img_proflie'] = $row['link_img_proflie'];
		$posts['link_img_post'] = $row['link_img_post'];
		$posts['description'] = $row['description'];
		$posts['comments'] = $row['comments'];
		$posts['favorite'] = $row['favorite'];
		
		
		array_push($response , $posts);
		
	}
	
	
}else {
	
	echo "Wrong";

}


echo json_encode($response);
mysqli_close($connection);


?>