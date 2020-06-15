package com.thoughtworks

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.{DataFrame, SparkSession}

object TestClass {

  def main(args: Array[String]): Unit = {

    Logger.getLogger("org").setLevel(Level.OFF)

    val spark = SparkSession.builder()
      .appName("Test Application")
      .master("local[*]")
      .getOrCreate()

    import spark.implicits._

    val lines: DataFrame = spark.readStream
        .format("socket")
        .option("host", "localhost")
        .option("port", "9999")
        .load()

    val words = lines.as[String].flatMap(_.split(" "))

    val wordsCount = words.groupBy("value").count()

    val query = wordsCount.writeStream
        .outputMode("complete")
        .format("console")
        .start()

    query.awaitTermination()

  }
}