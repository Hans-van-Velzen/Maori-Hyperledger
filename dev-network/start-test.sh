sudo systemctl start docker
sudo systemctl enable docker

cd ~/git/Maori-Hyperledger/dev-network/

./network.sh up createChannel # -ca # starts up with certificate authorities
./network.sh createChannel #<channelname>

# deploys a chaincode on the channel
#./network.sh deployCC -ccn basic -ccp ../asset-transfer-basic/chaincode-go -ccl go
# Javascript
./network.sh deployCC -ccn basic -ccp ../asset-transfer-basic/chaincode-javascript -ccl javascript

# set environment for Waka-district1
export CORE_PEER_TLS_ENABLED=true
#export CORE_PEER_LOCALMSPID="Org1MSP"
export CORE_PEER_LOCALMSPID="Waka-district1MSP"
export CORE_PEER_TLS_ROOTCERT_FILE=${PWD}/organizations/peerOrganizations/Waka-district1.example.com/peers/peer0.Waka-district1.example.com/tls/ca.crt
export CORE_PEER_MSPCONFIGPATH=${PWD}/organizations/peerOrganizations/Waka-district1.example.com/users/Admin@Waka-district1.example.com/msp
export CORE_PEER_ADDRESS=localhost:7051

# initialize some assets
peer chaincode invoke -o localhost:7050 --ordererTLSHostnameOverride orderer.example.com --tls --cafile ${PWD}/organizations/ordererOrganizations/example.com/orderers/orderer.example.com/msp/tlscacerts/tlsca.example.com-cert.pem -C mychannel -n basic --peerAddresses localhost:7051 --tlsRootCertFiles ${PWD}/organizations/peerOrganizations/Waka-district1.example.com/peers/peer0.Waka-district1.example.com/tls/ca.crt --peerAddresses localhost:9051 --tlsRootCertFiles ${PWD}/organizations/peerOrganizations/Waka-district2.example.com/peers/peer0.Waka-district2.example.com/tls/ca.crt -c '{"function":"InitLedger","Args":[]}'

# retrieve the assets

#Transfer an asset from one to aonther org
peer chaincode invoke -o localhost:7050 --ordererTLSHostnameOverride orderer.example.com --tls --cafile "${PWD}/organizations/ordererOrganizations/example.com/orderers/orderer.example.com/msp/tlscacerts/tlsca.example.com-cert.pem" -C mychannel -n basic --peerAddresses localhost:7051 --tlsRootCertFiles "${PWD}/organizations/peerOrganizations/Waka-district1.example.com/peers/peer0.Waka-district1.example.com/tls/ca.crt" --peerAddresses localhost:9051 --tlsRootCertFiles "${PWD}/organizations/peerOrganizations/Waka-district2.example.com/peers/peer0.Waka-district2.example.com/tls/ca.crt" -c '{"function":"TransferAsset","Args":["asset6","Christopher"]}'

# Environment variables for Waka-district2
export CORE_PEER_TLS_ENABLED=true
export CORE_PEER_LOCALMSPID="Waka-district2MSP"
export CORE_PEER_TLS_ROOTCERT_FILE=${PWD}/organizations/peerOrganizations/Waka-district2.example.com/peers/peer0.Waka-district2.example.com/tls/ca.crt
export CORE_PEER_MSPCONFIGPATH=${PWD}/organizations/peerOrganizations/Waka-district2.example.com/users/Admin@Waka-district2.example.com/msp
export CORE_PEER_ADDRESS=localhost:9051

# Query the transferred asset
peer chaincode query -C mychannel -n basic -c '{"Args":["ReadAsset","asset6"]}'

# close the network again
./network.sh down
