package com.thoughtworks

import org.apache.spark.SparkConf
import org.apache.spark.sql._
import org.apache.spark.sql.functions._

object TestDataframe extends App {

  val conf = new SparkConf().setAppName("Test-Data-Frame").setMaster("local[*]")

  val spark = SparkSession.builder()
    .config(conf)
    .getOrCreate()

  import spark.implicits._
  val df = Seq((1, 2), (2, 3), (3, 4), (1, 2)).toDF("x", "y")

  df.distinct()

}
