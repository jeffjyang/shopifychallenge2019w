cd src

echo "building..."
bundle exec middleman build --clean

cd ..

cp -r src/build/* .

echo "cleaning up..."
rm -rf src/build

echo "done"
