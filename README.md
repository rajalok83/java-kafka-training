# java-kafka-training
This library contains code written in plain Java using Apache Kafka Client library.
Below libraries were added to the Project Path in IntelliJ
1. Kafka Client library(kafka_clients_1_0_0.jar)
1. sl4j-api library(slf4j_api_1_7_25.jar)

Below libraries were required only with code using Serialization/Deserialization to and from JSON using Jackson libraries
1. Jackson Annotation(jackson_annotations_2_9_1.jar)
1. Jakson Core(jackson_core_2_9_1.jar)
1. Jackson Databind(jackson_databind_2_9_1.jar)

All the above libraries could be found under $KAFKA_HOME/libs/

### Setup steps:
1. Downlad Apache Kafka zipped file from [Apache Kafka Website](https://kafka.apache.org/downloads)
1. Unzip the downloaded file at a location
1. Set KAFKA_HOME
   1. **On Windows:** Set KAFKA_HOME as user environment variable
   1. **On Unix:** Have below command in either ~/.bashrc or ~/.profile based on your environment and source it in 
   > export KAFKA_HOME=<PATH_TO_UNZIPPED_DIRECTORY>

Apache Kafka commands that could be helpful are:
- **Start Zookeeper(default port:2181):**
  - __**On Unix:**__
  > ${KAFKA_HOME}/bin/zookeeper-server-start.sh ${KAFKA_HOME}/config/zookeeper.properties
  - __**On Windows:**__
  > %KAFKA_HOME%\bin\windows\zookeeper-server-start.bat %KAFKA_HOME%\config\zookeeper.properties
- **Start Broker(default port:9092):**
  - __**On Unix:**__
  > ${KAFKA_HOME}/bin/kafka-server-start.sh ${KAFKA_HOME}/config/server.properties
  - __**On Windows:**__
  > %KAFKA_HOME%\bin\windows\kafka-server-start.bat %KAFKA_HOME%\config\server.properties
- **Start Console Producer:**
  - __**On Unix:**__
  > ${KAFKA_HOME}/bin/kafka-console-producer.sh --broker-list localhost:9092 --topic <topic_name>
  - __**On Windows:**__
  > %KAFKA_HOME%\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic <topic_name>
- **Start Console Consumer:**
  - __**On Unix:**__
  > ${KAFKA_HOME}/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic <topic_name>[ --partition <part_num> --offset <offset_id> --from-beginning --group ]
  - __**On Windows:**__
  > %KAFKA_HOME%\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic <topic_name>[ --partition <part_num> --offset <offset_id> --from-beginning --group ]
  
  > kafka-run-class.bat kafka.tools.SimpleConsumerShell --broker-list localhost:9092 --topic <topic_name> --partition <part_num>
