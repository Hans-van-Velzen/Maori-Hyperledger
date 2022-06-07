echo "===== Cleaning the configtx ======"
rm ./config/*.tx  2> /dev/null
rm ./config/*.block 2> /dev/null
rm ./config/*.yaml
rm -rf ./crypto-config 2> /dev/null
rm -rf ./temp


echo "Done."