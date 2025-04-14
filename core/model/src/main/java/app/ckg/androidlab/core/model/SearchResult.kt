package app.ckg.androidlab.core.model

import kotlinx.datetime.Instant

/**
 * @see <a href="https://developers.naver.com/docs/serviceapi/search/shopping/shopping.md#%EC%87%BC%ED%95%91">네이버 쇼핑 검색 api</>
 *
 * @property lastBuildDate 검색 결과를 생성한 시간
 * @property total 총 검색 결과 개수
 * @property start 검색 시작 위치
 * @property display 한 번에 표시할 검색 결과 개수
 * @property item [SearchItem] 개별 검색 결과. JSON 형식의 결괏값에서는 items 속성의 JSON 배열로 개별 검색 결과를 반환합니다.
 */
data class SearchResult(
    val lastBuildDate: Instant,
    val total: Int,
    val start: Int,
    val display: Int,
    val item: List<SearchItem>
)
