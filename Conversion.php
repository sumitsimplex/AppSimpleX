<?php
      $amount = urldecode($_GET["amount"]);
      $from = urldecode($_GET["from"]);
      $to = "INR";
      $data = file_get_contents("https://www.google.com/finance/converter?a=$amount&from=$from&to=$to");
  	preg_match("/<span class=bld>(.*)<\/span>/",$data, $converted);
  	$converted = preg_replace("/[^0-9.]/", "", $converted[1]);
  	$response = array();
  	$response["conversion"] = number_format(round($converted, 3),2);
      echo json_encode($response);
  ?>