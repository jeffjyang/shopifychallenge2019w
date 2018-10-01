
echo "Enter target project:"
read APPENGINE_PROJECT

echo "Enter version:"
read VERSION

mvn clean install appengine:deploy -Dapp.deploy.project=$APPENGINE_PROJECT -Dapp.deploy.version=$VERSION
