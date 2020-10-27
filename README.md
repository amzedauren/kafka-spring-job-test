Start a cluster:

- ```docker-compose up -d ```

Add more brokers:

- ```docker-compose scale kafka=3```

Destroy a cluster:

- ```docker-compose stop```

to test consumer:

- ```sudo docker attach ms_consumer1_x``` 
я думал подключить базу данных или логгер, что бы проверить, посчитал это лишним 
