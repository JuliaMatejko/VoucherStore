## Voucher Shop

![Java CI with Maven](https://github.com/JuliaMatejko/VoucherStore/workflows/Java%20CI%20with%20Maven/badge.svg)

### Testing

```bash
mvn test
```

### testing via curl

```bash
curl -X POST localhost:9999/api/clients -H 'content-type: application/json' -d '{"firstname": "Julia", "lastname": "Matejko", "address": {"street": "prosta"}}'
curl -X POST localhost:9999/api/clients -H 'content-type: application/json' -d '{"firstname": "Julia", "lastname": "Matejko", "address": {"street": "krzywa"}}'
curl -X POST localhost:9999/api/clients -H 'content-type: application/json' -d '{"firstname": "Julia", "lastname": "Matejko", "address": {"street": "dluga"}}'

curl localhost:9999/api/clients | jq
curl localhost:9999/api/clients | python -m json.tool
```