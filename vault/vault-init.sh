#!/bin/sh

vault login ${VAULT_TOKEN}

vault secrets disable secret
vault secrets enable -version=1 -path=secret kv

# Add secrets
vault kv put secret/application @${VAULT_SOURCE_DIR}/application.json
vault kv put secret/sps-bff-service @${VAULT_SOURCE_DIR}/sps-bff-service.json
vault kv put secret/sps-accounts-service @${VAULT_SOURCE_DIR}/sps-accounts-service.json
vault kv put secret/sps-transactions-service @${VAULT_SOURCE_DIR}/sps-transactions-service.json
