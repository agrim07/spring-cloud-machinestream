## Coding Case (Backend)
ZEISS MachineStream is a proposed smart maintenance solution for large industrial clients using different ZEISS products such as microscopes and measurement machines. It is planned to allow an operator to monitor these assets remotely in near real-time.

ZEISS Digital Partners have decided to do this project together with two business groups, namely Industrial Metrology (IMT) and Microscopy (MIC). A total of 28 microscopes and measurement machines are already deployed at the ZEISS Digital Partners offices for testing purposes. One of your colleagues has also already created a prototypical backend which is documented below.

Currently, the machines emit their data via a websocket only. You are tasked with ingesting and storing the data, finally exposing it to the frontend dev team via a JSON - based API
## Solution

This application having three parts:

1) Machine Health Status Source - This is used to generate machine health events in kafka topic.
2) Machine Health Status Processor - This is used to consumed events from kafka topic and process/stored it database..
3) Rest Api endpoints - Used to get/post machine health status.

## Pre-requisites

Step 1: Start the Messaging Servers
In a fresh terminal window, go to the root folder of the project and issue the following command.

You’ll need “Docker” to be installed and running on your system for this script to work properly as it requires docker-compose.

./start-servers.sh

This script will start Kafka and stream the log output from both to the terminal window (unless you exit with Ctrl-C). The servers do not stop when you press Ctrl-C - they’ll keep running in the background. Once started these servers will all be available to applications running on your computer.

Step 2: Generate Some Machine health Events using machine-health-source application

Step 3: Consume and process/store events in in-memory sqllite database using machine-health-processor application.

Step 4: Can get events from rest api endpoints("/machine-health-status" & "/machine-health-status/{machineId}") using machine-health-processor application.