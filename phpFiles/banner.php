<?php
include "connect.php";
$apps=array();
$query="SELECT * FROM banner ";
$res=$connect->prepare($query);
$res->execute();
while($row=$res->fetch(PDO::FETCH_ASSOC)){
    $record=array();
    $record["id"]=$row["id"];
    $record["url"]=$row["url"];

    $apps[]=$record;
}

echo JSON_encode($apps);