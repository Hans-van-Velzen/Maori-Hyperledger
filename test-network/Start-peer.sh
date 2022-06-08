# Launches the peer process
# use the init-peers to initialise

# Set the environment variables for overriding the config in core.yaml

export CONFIG_DIRECTORY=$PWD/config-peers
export FABRIC_CFG_PATH=/home/hyperdev/git/Maori-Hyperledger/test-network/config-peers

# export CORE_LOGGING_LEVEL=DEBUG
export FABRIC_LOGGING_SPEC=INFO

# Launch the peer with Peer's Identity/MSP
export CORE_PEER_MSPCONFIGPATH=$PWD/crypto-config/peerOrganizations/waka1.maori/peers/peer0.waka1.maori/msp

# Launch the node 
peer node start