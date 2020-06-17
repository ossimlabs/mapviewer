# mapviewer

1. git clone git@github.com:ossimlabs/mapviewer.git
2. cd mapviewer
3. grails run-app
4. open http://localhost:8080

need to have java, gradle, and grails installed

# To Build Docker image
./build.sh

# To Run as Docker image
./run.sh

# To run with local K8S
## In dev mode
skaffold dev 
## In prod mod
skaffold run
