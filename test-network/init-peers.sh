#1 Clean up
./clean-peers.sh

BASE_CONFIG_DIR=./setup/config

#2 Copy the YAML files
if [ ! -z $1 ]; then
    if [ $1 == "all" ]; then

        cp $BASE_CONFIG_DIR/crypto-config-Waka-district1.yaml ./config-peers
        cp $BASE_CONFIG_DIR/crypto-config-Waka-district2.yaml ./config-peers
        cp $BASE_CONFIG_DIR/core.yaml ./config-peers
        echo    'Copied: crypto-config*.yaml; core.yaml files.'
        
    fi
else
    echo 'Use ./ini-peers.sh   all      to initialize crypto-config.yaml, configtx and orderer YAML'
fi

#3. Setup cryptogen for peers
echo    '================ Generating crypto-config ================'
rm -rf ./crypto-config/peerOrganizations 2> /dev/null
cryptogen extend --config=./config-peers/crypto-config-Waka-district1.yaml
cryptogen extend --config=./config-peers/crypto-config-Waka-district2.yaml

