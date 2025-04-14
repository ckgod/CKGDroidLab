package app.ckg.androidlab.core.model


/**
 * @see <a href="https://developers.naver.com/docs/serviceapi/search/shopping/shopping.md#%EC%87%BC%ED%95%91">네이버 쇼핑 검색 api</>
 *
 * @property title 상품 이름. 이름에서 검색어와 일치하는 부분은 <b> 태그로 감싸져 있습니다.
 * @property link 상품 정보 URL
 * @property image 섬네일 이미지의 URL
 * @property lprice 최저가. 최저가 정보가 없으면 0을 반환합니다. 가격 비교 데이터가 없으면 상품 가격을 의미합니다.
 * @property hprice 최고가. 최고가 정보가 없거나 가격 비교 데이터가 없으면 0을 반환합니다.
 * @property mallName 상품을 판매하는 쇼핑몰. 쇼핑몰 정보가 없으면 네이버를 반환합니다.
 * @property productId 네이버 쇼핑의 상품 ID
 * @property productType 상품군과 상품 종류에 따른 상품 타입. 상품군과 상품 종류에 따른 상품 타입은 상품군 타입의 표를 참고합니다.
 * - 상품군: 일반상품, 중고상품, 단종상품, 판매예정상품
 * - 상품 종류: 가격비교 상품, 가격비교 비매칭 일반상품, 가격비교 매칭 일반상품
 * @property maker 제조사
 * @property brand 브랜드
 * @property category1 상품의 카테고리(대분류)
 * @property category2 상품의 카테고리(중분류)
 * @property category3 상품의 카테고리(소분류)
 * @property category4 상품의 카테고리(세분류)
 */
data class SearchItem(
    val title: String,
    val link: String,
    val image: String,
    val lprice: Int,
    val hprice: Int,
    val mallName: String,
    val productId: Int,
    val productType: Int,
    val maker: String,
    val brand: String,
    val category1: String,
    val category2: String,
    val category3: String,
    val category4: String
)
