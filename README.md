# spring-playground-services
Repository to store all services related to this hoppy project

## Running the services
Steps to run infrastructure services first (eg. config server, kibana etc.) and then run the other app services.
1. `docker-compose --profile infrastructure up -d --build`
2. `docker-compose --profile sps up -d --build`

## Environment variables
| Var                        | Comment                                                             |
| -------------------------- | ------------------------------------------------------------------- |
| STACK_VERSION              | Version of ELK stack components                                     |
| STACK_LICENSE              | License for ELK components                                          |
| CLUSTER_NAME               | Name of ELK cluster                                                 |
| ELASTIC_PASSWORD           | Superuser role, full access to cluster management and data indices. |
| LOGSTASH_INTERNAL_PASSWORD | The user Logstash uses to connect and send data to Elasticsearch.   |
| KIBANA_SYSTEM_PASSWORD     | The user Kibana uses to connect and communicate with Elasticsearch. |

## Environment variables
| Var                    | Service                 | Comment                                            |
| ---------------------- | ----------------------- | -------------------------------------------------- |
| SPRING_PROFILES_ACTIVE | *                       | Determines environment in which the app is run     |
| EUREKA_URI             | * (except conf. server) | Points to service registry instance                |
| LOGSTASH_URI           | * (except eureka)       | Points to logstash instance                        |
| CONFIG_USER            | *                       | Basic auth user for interaction with config server |
| CONFIG_PASS            | *                       | Basic auth pass for interaction with config server |
| CONFIG_GIT_REPO        | config-server           | URL to git repo where config files are placed      |