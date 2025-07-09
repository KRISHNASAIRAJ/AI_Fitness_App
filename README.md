# AI_Fitness_App






So here we are using rabbitMQ for asynchronous activity because when you hit api call with details of activity the AI cant process immediately with all recommendations, suggestions,.. so you are blocking the processed one's to avoid this we will display the processed which will avoid delay in AI api.

docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:4-management