<?php
include "connect.php";
$search=trim($_GET["search"]);
$apps=array();
$query=" SELECT * FROM news WHERE title like '%".$search."%' ";
$res=$connect->prepare($query);
$res->bindParam(":search",$search);
$res->execute();

while($row=$res->fetch(PDO::FETCH_ASSOC)){
    $record=array();
    $record["id"]=$row["id"];
    $record["title"]=$row["title"];
    $record["description"]=$row["description"];
    $record["image"]=$row["image"];
    $record["video"]=$row["video"];
    $record["date"]=$row["date"];

    $apps[]=$record;


}

echo  JSON_encode($apps);