package com.example.blume_mobile.data

import com.example.blume_mobile.models.address.Address
import com.example.blume_mobile.models.Establishment
import com.example.blume_mobile.models.local.Local
import com.example.blume_mobile.models.phone.Phone
import com.example.blume_mobile.models.Status

val address = Address(
    id = 1,
    uf = "SP",
    city = "São Paulo",
    zipCode = "08474230",
    publicPlace = "Rua Teste"
)

val local = Local(
    id = 1,
    number = 7,
    address = address,
    block = null,
    floor = null,
    complement = null

)

val phone = Phone(
    id = 1,
    number = "933357637",
    areaCode = "11",
    countryCode = "55"
)

val status = Status(
    id = 1,
    name = "Ativo",
    type = "Estabelecimento"
)

val sampleEstablishments = listOf(
    Establishment(
        id = 1,
        name = "Salão01",
        description = "Salão de Beleza muito bonito e charmoso na avenida paulista",
        cnpj = "50709903812/45",
        local = local,
        media = 2.0,
        phone = phone,
        imgUrl = "https://www.brognoli.com.br/blog/wp-content/uploads/2022/10/pexels-kaichieh-chan-8495948-scaled-1.jpg",
        status = status,
        aditumId = "teste1",
        endShift = "18:00:00",
        startShit = "10:00:00"
    ),
    Establishment(
        id = 2,
        name = "Salão02",
        description = "Salão muito barato e charmoso na avenida paulista",
        cnpj = "507091223812/45",
        local = local,
        media = 5.0,
        phone = phone,
        imgUrl = "https://rgladvogados.com/wp-content/uploads/2021/10/1-750x500.png",
        status = status,
        aditumId = "teste2",
        endShift = "18:00:00",
        startShit = "10:00:00"
    ),
    Establishment(
        id = 2,
        name = "Teste 03",
        description = "Salão muito caro avenida paulista",
        cnpj = "50709903812/43",
        local = local,
        media = 3.0,
        phone = phone,
        imgUrl = "https://portalbelohorizonte.com.br/sites/default/files/styles/normal_size/public/arquivos/comer-e-beber/2020-07/estface3-1.jpg?itok=KqP78SY-",
        status = status,
        aditumId = "teste3",
        endShift = "18:00:00",
        startShit = "10:00:00"
    ),
    Establishment(
        id = 1,
        name = "Salão01",
        description = "Salão de Beleza muito bonito e charmoso na avenida paulista",
        cnpj = "50709903812/45",
        local = local,
        media = 2.0,
        phone = phone,
        imgUrl = "https://www.brognoli.com.br/blog/wp-content/uploads/2022/10/pexels-kaichieh-chan-8495948-scaled-1.jpg",
        status = status,
        aditumId = "teste1",
        endShift = "18:00:00",
        startShit = "10:00:00"
    ),
    Establishment(
        id = 1,
        name = "Salão06",
        description = "Salão de Beleza muito bonito e charmoso na avenida paulista",
        cnpj = "50709903812/45",
        local = local,
        media = 2.0,
        phone = phone,
        imgUrl = "https://www.brognoli.com.br/blog/wp-content/uploads/2022/10/pexels-kaichieh-chan-8495948-scaled-1.jpg",
        status = status,
        aditumId = "teste1",
        endShift = "18:00:00",
        startShit = "10:00:00"
    ),
    Establishment(
        id = 1,
        name = "Salão05",
        description = "Salão de Beleza muito bonito e charmoso na avenida paulista",
        cnpj = "50709903812/45",
        local = local,
        media = 2.0,
        phone = phone,
        imgUrl = "https://www.brognoli.com.br/blog/wp-content/uploads/2022/10/pexels-kaichieh-chan-8495948-scaled-1.jpg",
        status = status,
        aditumId = "teste1",
        endShift = "18:00:00",
        startShit = "10:00:00"
    ),
)