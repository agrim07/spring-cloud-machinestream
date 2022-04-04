# Machine health processor Service

This application recieves machine health events with status IDLE/RUNNING/FINISHED/ERRORED 
and in case of ERRORED this application will push an event otherwise store all events in database.
This application is also having an end-point used to get the status of all machines in json format.
