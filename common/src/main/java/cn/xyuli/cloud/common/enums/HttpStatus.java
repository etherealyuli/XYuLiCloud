package cn.xyuli.cloud.common.enums;


/**
 * @ClassName HttpStatus
 * @Description TODO spring的HttpStatus，只对响应描述进行了翻译
 * @Author xyuli
 * @Date 2022/3/4 3:13 PM
 * @Version 1.0
 **/
public enum HttpStatus {
    // 1xx 信息

    /**
     * {@code 100 继续}.
     */
    CONTINUE(100, HttpStatus.Series.INFORMATIONAL, "继续"),
    /**
     * {@code 101 切换协议}.
     */
    SWITCHING_PROTOCOLS(101, HttpStatus.Series.INFORMATIONAL, "切换协议"),
    /**
     * {@code 102 处理中}.
     * 服务器已接受完整请求但尚未完成的一个临时响应。
     */
    PROCESSING(102, HttpStatus.Series.INFORMATIONAL, "处理中"),

    // 2xx 成功

    /**
     * {@code 200 请求成功}.
     */
    OK(200, HttpStatus.Series.SUCCESSFUL, "请求成功"),
    /**
     * {@code 201 已创建}.
     * 成功请求并创建了新的资源
     */
    CREATED(201, HttpStatus.Series.SUCCESSFUL, "已创建"),
    /**
     * {@code 202 已接受}.
     * 已经接受请求，但未处理完成
     */
    ACCEPTED(202, HttpStatus.Series.SUCCESSFUL, "已接受"),
    /**
     * {@code 203 非授权信息}.
     * 请求成功。但返回的meta信息不在原始的服务器，而是一个副本
     */
    NON_AUTHORITATIVE_INFORMATION(203, HttpStatus.Series.SUCCESSFUL, "非授权信息"),
    /**
     * {@code 204 无内容}.
     * 服务器成功处理，但未返回内容。在未更新网页的情况下，可确保浏览器继续显示当前文档
     */
    NO_CONTENT(204, HttpStatus.Series.SUCCESSFUL, "无内容"),
    /**
     * {@code 205 重置内容}.
     *  服务器处理成功，用户终端（例如：浏览器）应重置文档视图。可通过此返回码清除浏览器的表单域
     */
    RESET_CONTENT(205, HttpStatus.Series.SUCCESSFUL, "重置内容"),
    /**
     * {@code 206 部分内容}.
     * 服务器成功处理了部分GET请求
     */
    PARTIAL_CONTENT(206, HttpStatus.Series.SUCCESSFUL, "部分内容"),
    /**
     * {@code 207 Multi-Status}.
     * @see <a href="https://tools.ietf.org/html/rfc4918#section-13">WebDAV</a>
     */
    MULTI_STATUS(207, HttpStatus.Series.SUCCESSFUL, "Multi-Status"),
    /**
     * {@code 208 已报告}.
     */
    ALREADY_REPORTED(208, HttpStatus.Series.SUCCESSFUL, "已报告"),
    /**
     * {@code 226 IM Used}.
     */
    IM_USED(226, HttpStatus.Series.SUCCESSFUL, "IM Used"),

    // 3xx 重定向

    /**
     * {@code 300 多种选择}.
     * 请求的资源可包括多个位置，相应可返回一个资源特征与地址的列表用于用户终端（例如：浏览器）选择
     */
    MULTIPLE_CHOICES(300, HttpStatus.Series.REDIRECTION, "多种选择"),
    /**
     * {@code 301 永久移动}.
     * 请求的资源已被永久的移动到新URI，返回信息会包括新的URI，浏览器会自动定向到新URI。今后任何新的请求都应使用新的URI代替
     */
    MOVED_PERMANENTLY(301, HttpStatus.Series.REDIRECTION, "永久移动"),
    /**
     * {@code 302 临时移动}.
     * 与301类似。但资源只是临时被移动。客户端应继续使用原有URI
     */
    FOUND(302, HttpStatus.Series.REDIRECTION, "临时移动"),
    /**
     * {@code 302 临时移动}.
     * 与301类似。但资源只是临时被移动。客户端应继续使用原有URI
     */
    @Deprecated
    MOVED_TEMPORARILY(302, HttpStatus.Series.REDIRECTION, "临时移动"),
    /**
     * {@code 303 查看其它地址}.
     * 与301类似。使用GET和POST请求查看
     */
    SEE_OTHER(303, HttpStatus.Series.REDIRECTION, "查看其它地址"),
    /**
     * {@code 304 未修改}.
     * 所请求的资源未修改，服务器返回此状态码时，不会返回任何资源。客户端通常会缓存访问过的资源，通过提供一个头信息指出客户端希望只返回在指定日期之后修改的资源
     */
    NOT_MODIFIED(304, HttpStatus.Series.REDIRECTION, "未修改"),
    /**
     * {@code 305 使用代理}.
     * 所请求的资源必须通过代理访问
     */
    @Deprecated
    USE_PROXY(305, HttpStatus.Series.REDIRECTION, "Use Proxy"),
    /**
     * {@code 307 临时重定向}.
     * 与302类似。使用GET请求重定向
     */
    TEMPORARY_REDIRECT(307, HttpStatus.Series.REDIRECTION, "Temporary Redirect"),
    /**
     * {@code 308 永久重定向}.
     */
    PERMANENT_REDIRECT(308, HttpStatus.Series.REDIRECTION, "永久重定向"),

    // --- 4xx 客户端错误 ---

    /**
     * {@code 400 错误的请求}.
     * 客户端请求的语法错误，服务器无法理解
     */
    BAD_REQUEST(400, HttpStatus.Series.CLIENT_ERROR, "缺少所需的请求正文或参数"),
    /**
     * {@code 401 认证信息验证失败}.
     * 请求要求用户的身份认证
     */
    UNAUTHORIZED(401, HttpStatus.Series.CLIENT_ERROR, "请验证认证信息"),
    /**
     * {@code 402 保留，将来使用}.
     * 保留，将来使用
     */
    PAYMENT_REQUIRED(402, HttpStatus.Series.CLIENT_ERROR, "保留，将来使用"),
    /**
     * {@code 403 无此权限}.
     * 服务器理解请求客户端的请求，但是拒绝执行此请求
     */
    FORBIDDEN(403, HttpStatus.Series.CLIENT_ERROR, "无此权限"),
    /**
     * {@code 404 未找到此资源}.
     * 服务器无法根据客户端的请求找到资源（网页）。通过此代码，网站设计人员可设置"您所请求的资源无法找到"的个性页面
     */
    NOT_FOUND(404, HttpStatus.Series.CLIENT_ERROR, "未找到此资源"),
    /**
     * {@code 405 不允许的请求方法}.
     * 客户端请求中的方法被禁止
     */
    METHOD_NOT_ALLOWED(405, HttpStatus.Series.CLIENT_ERROR, "不允许的请求方法"),
    /**
     * {@code 406 无法接受}.
     * 服务器端无法提供与  Accept-Charset 以及 Accept-Language 消息头指定的值相匹配的响应。
     */
    NOT_ACCEPTABLE(406, HttpStatus.Series.CLIENT_ERROR, "无法接受"),
    /**
     * {@code 407 请使用代理验证认证信息}.
     * 请求要求代理的身份认证，与401类似，但请求者应当使用代理进行授权
     */
    PROXY_AUTHENTICATION_REQUIRED(407, HttpStatus.Series.CLIENT_ERROR, "请使用代理验证认证信息"),
    /**
     * {@code 408 请求超时}.
     * 服务器等待客户端发送的请求时间过长，超时
     */
    REQUEST_TIMEOUT(408, HttpStatus.Series.CLIENT_ERROR, "请求超时"),
    /**
     * {@code 409 发生冲突}.
     * 服务器完成客户端的 PUT 请求时可能返回此代码，服务器处理请求时发生了冲突
     */
    CONFLICT(409, HttpStatus.Series.CLIENT_ERROR, "发生冲突"),
    /**
     * {@code 410 客户端请求的资源已经不存在}.
     *     客户端请求的资源已经不存在。410不同于404，如果资源以前有现在被永久删除了可使用410代码，网站设计人员可通过301代码指定资源的新位置
     */
    GONE(410, HttpStatus.Series.CLIENT_ERROR, "客户端请求的资源已经不存在"),
    /**
     * {@code 411 需要长度信息}.
     * 服务器无法处理客户端发送的不带Content-Length的请求信息
     */
    LENGTH_REQUIRED(411, HttpStatus.Series.CLIENT_ERROR, "需要长度信息"),
    /**
     * {@code 412 头信息验证失败}.
     *     客户端请求信息的先决条件错误
     */
    PRECONDITION_FAILED(412, HttpStatus.Series.CLIENT_ERROR, "前提条件验证失败"),
    /**
     * {@code 413 请求的实体过大}.
     * 由于请求的实体过大，服务器无法处理，因此拒绝请求。为防止客户端的连续请求，服务器可能会关闭连接。如果只是服务器暂时无法处理，则会包含一个Retry-After的响应信息
     */
    PAYLOAD_TOO_LARGE(413, HttpStatus.Series.CLIENT_ERROR, "请求的实体过大"),
    /**
     * {@code 414请求的URI过长}.
     * 请求的URI过长（URI通常为网址），服务器无法处理
     */
    URI_TOO_LONG(414, HttpStatus.Series.CLIENT_ERROR, "请求的URI过长"),
   /**
     * {@code 415 服务器无法处理请求附带的媒体格式}.
     * 服务器无法处理请求附带的媒体格式
     */
    UNSUPPORTED_MEDIA_TYPE(415, HttpStatus.Series.CLIENT_ERROR, "服务器无法处理请求附带的媒体格式"),
    /**
     * {@code 416 客户端请求的范围无效}.
     * 客户端请求的范围无效
     */
    REQUESTED_RANGE_NOT_SATISFIABLE(416, HttpStatus.Series.CLIENT_ERROR, "客户端请求的范围无效"),
    /**
     * {@code 417 Expect请求头信息错误}.
     *     服务器无法满足Expect的请求头信息
     */
    EXPECTATION_FAILED(417, HttpStatus.Series.CLIENT_ERROR, "Expect请求头信息错误"),
    /**
     * {@code 418 I'm a teapot}.
     * 服务器拒绝冲泡咖啡，因为它是个茶壶。
     * 该错误是超文本咖啡壶控制协议的参考，和 1998 年愚人节的玩笑。
     */
    I_AM_A_TEAPOT(418, HttpStatus.Series.CLIENT_ERROR, "I'm a teapot"),
    /**
     * {@code 422 客户端不应在不修改的情况下重复发送此请求}.
     * 服务器理解请求实体的内容类型，并且请求实体的语法是正确的，但是服务器无法处理所包含的指令。
     */
    UNPROCESSABLE_ENTITY(422, HttpStatus.Series.CLIENT_ERROR, "Unprocessable Entity"),
    /**
     * {@code 423 当前资源被锁定}.
     * 当前资源被锁定
     */
    LOCKED(423, HttpStatus.Series.CLIENT_ERROR, "当前资源被锁定"),
    /**
     * {@code 424 请求失败}.
     * 由于之前的某个请求发生的错误，导致当前请求失败
     */
    FAILED_DEPENDENCY(424, HttpStatus.Series.CLIENT_ERROR, "Failed Dependency"),
    /**
     * {@code 425 拒绝使用Early Data（早期数据）}.
     * 代表服务器不愿意冒风险来处理该请求，原因是处理该请求可能会被“重放”，从而造成潜在的重放攻击
     * 重放攻击（英语：replay attack，或称为回放攻击）是一种恶意或欺诈的重复或延迟有效数据的网络攻击形式。 这可以由发起者或由拦截数据并重新传输数据的对手来执行。这是“中间人攻击”的一个较低级别版本。
     */
    TOO_EARLY(425, HttpStatus.Series.CLIENT_ERROR, "Too Early"),
    /**
     * {@code 426 需要升级协议}.
     * 服务器拒绝处理客户端使用当前协议发送的请求，但是可以接受其使用升级后的协议发送的请求。
     */
    UPGRADE_REQUIRED(426, HttpStatus.Series.CLIENT_ERROR, "需要升级协议"),
    /**
     * {@code 428 缺少必要的头信息}.
     * 一般的，这种情况意味着必要的条件首部——如 If-Match ——的缺失。
     */
    PRECONDITION_REQUIRED(428, HttpStatus.Series.CLIENT_ERROR, "缺少必要的头信息"),
    /**
     * {@code 429 频次限制}.
     * 在一定的时间内用户发送了太多的请求，即超出了“频次限制”。
     */
    TOO_MANY_REQUESTS(429, HttpStatus.Series.CLIENT_ERROR, "频次限制"),
    /**
     * {@code 431 请求头字段信息太大}.
     * 由于请求中的首部字段的值过大，服务器拒绝接受客户端的请求。客户端可以在缩减首部字段的体积后再次发送请求。
     */
    REQUEST_HEADER_FIELDS_TOO_LARGE(431, HttpStatus.Series.CLIENT_ERROR, "请求头字段信息太大"),
    /**
     * {@code 451 因法律原因不可用}.
     * 服务器由于法律原因，无法提供客户端请求的资源，例如可能会导致法律诉讼的页面。
     */
    UNAVAILABLE_FOR_LEGAL_REASONS(451, HttpStatus.Series.CLIENT_ERROR, "因法律原因不可用"),

    // --- 5xx 服务器错误 ---

    /**
     * {@code 500 内部服务器错误}.
     * 请求的服务器遇到意外的情况并阻止其执行请求。
     */
    INTERNAL_SERVER_ERROR(500, HttpStatus.Series.SERVER_ERROR, "内部服务器错误"),
    /**
     * {@code 501 不支持请求}.
     * 服务器不支持当前请求所需要的某个功能。当服务器无法识别请求的方法，并且无法支持其对任何资源的请求。（例如，网络服务API的新功能）
     */
    NOT_IMPLEMENTED(501, HttpStatus.Series.SERVER_ERROR, "不支持请求"),
    /**
     * {@code 502 错误的路由}.
     * 作为网关或者代理工作的服务器尝试执行请求时，从上游服务器接收到无效的响应。
     */
    BAD_GATEWAY(502, HttpStatus.Series.SERVER_ERROR, "错误的路由"),
    /**
     * {@code 503 服务器维护或者过载}.
     * 由于临时的服务器维护或者过载，服务器当前无法处理请求。这个状况是暂时的，并且将在一段时间以后恢复。如果能够预计延迟时间，那么响应中可以包含一个Retry-After头用以标明这个延迟时间。如果没有给出这个Retry-After信息，那么客户端应当以处理500响应的方式处理它。
     */
    SERVICE_UNAVAILABLE(503, HttpStatus.Series.SERVER_ERROR, "服务器维护或者过载"),
    /**
     * {@code 504 路由超时}.
     * 作为网关或者代理工作的服务器尝试执行请求时，未能及时从上游服务器（URI标识出的服务器，例如HTTP、FTP、LDAP）或者辅助服务器（例如DNS）收到响应。
     * 注意：某些代理服务器在DNS查询超时时会返回400或者500错误。
     */
    GATEWAY_TIMEOUT(504, HttpStatus.Series.SERVER_ERROR, "路由超时"),
    /**
     * {@code 505 不支持的版本}.
     * 服务器不支持，或者拒绝支持在请求中使用的HTTP版本。[63]这暗示着服务器不能或不愿使用与客户端相同的版本。响应中应当包含一个描述了为何版本不被支持以及服务器支持哪些协议的实体。
     */
    HTTP_VERSION_NOT_SUPPORTED(505, HttpStatus.Series.SERVER_ERROR, "不支持的版本"),
    /**
     * {@code 506 务器存在内部配置错误}
     * 服务器存在内部配置错误，被请求的协商变元资源被配置为在透明内容协商中使用自己，因此在一个协商处理中不是一个合适的重点。
     */
    VARIANT_ALSO_NEGOTIATES(506, HttpStatus.Series.SERVER_ERROR, "务器存在内部配置错误"),
    /**
     * {@code 507 存储空间不足}
     * @see <a href="https://tools.ietf.org/html/rfc4918#section-11.5">WebDAV</a>
     * 服务器无法存储完成请求所必须的内容。这个状况被认为是临时的。
     */
    INSUFFICIENT_STORAGE(507, HttpStatus.Series.SERVER_ERROR, "存储空间不足"),
    /**
     * {@code 508 陷入死循环}
     * 服务器在处理请求时陷入死循环。
     */
    LOOP_DETECTED(508, HttpStatus.Series.SERVER_ERROR, "陷入死循环"),
    /**
     * {@code 509 超出带宽限制}
     *
     */
    BANDWIDTH_LIMIT_EXCEEDED(509, HttpStatus.Series.SERVER_ERROR, "超出带宽限制"),
    /**
     * {@code 510 请求不支持任何所描述的扩展}
     * 一个客户端可以发送一个包含扩展声明的请求，该声明描述了要使用的扩展。如果服务器接收到这样的请求，但是请求不支持任何所描述的扩展，那么服务器将使用510状态码进行响应。
     */
    NOT_EXTENDED(510, HttpStatus.Series.SERVER_ERROR, "请求不支持任何所描述的扩展"),
    /**
     * {@code 511 需要网络身份验证}.
     * 客户端需要进行身份验证才能获得网络访问权限，旨在限制用户群访问特定网络。
     */
    NETWORK_AUTHENTICATION_REQUIRED(511, HttpStatus.Series.SERVER_ERROR, "需要网络身份验证");


    private static final HttpStatus[] VALUES;

    static {
        VALUES = values();
    }


    private final int value;

    private final HttpStatus.Series series;

    private final String reasonPhrase;

    HttpStatus(int value, HttpStatus.Series series, String reasonPhrase) {
        this.value = value;
        this.series = series;
        this.reasonPhrase = reasonPhrase;
    }


    /**
     * 返回此状态码的整数值
     */
    public int value() {
        return this.value;
    }

    /**
     * 返回此状态码的 HTTP 状态系列。
     * @see HttpStatus.Series
     */
    public HttpStatus.Series series() {
        return this.series;
    }

    /**
     * 返回此状态码的原因短语
     */
    public String getReasonPhrase() {
        return this.reasonPhrase;
    }

    /**
     * 此状态码是否在 消息 HTTP 系列中
     * {@link HttpStatus.Series#INFORMATIONAL}.
     */
    public boolean is1xxInformational() {
        return (series() == HttpStatus.Series.INFORMATIONAL);
    }

    /**
     * 此状态码是否在 成功 HTTP 系列中
     * {@link HttpStatus.Series#SUCCESSFUL}.
     */
    public boolean is2xxSuccessful() {
        return (series() == HttpStatus.Series.SUCCESSFUL);
    }

    /**
     * 此状态码是否在 重定向 HTTP 系列中
     * {@link HttpStatus.Series#REDIRECTION}.
     */
    public boolean is3xxRedirection() {
        return (series() == HttpStatus.Series.REDIRECTION);
    }

    /**
     * 此状态码是否在 客户端错误 HTTP 系列中
     * {@link HttpStatus.Series#CLIENT_ERROR}.
     */
    public boolean is4xxClientError() {
        return (series() == HttpStatus.Series.CLIENT_ERROR);
    }

    /**
     * 此状态码是否在 服务器错误 HTTP 系列中
     * {@link HttpStatus.Series#SERVER_ERROR}.
     */
    public boolean is5xxServerError() {
        return (series() == HttpStatus.Series.SERVER_ERROR);
    }

    /**
     * 此状态码是否在 错误 HTTP 系列中
     * {@link HttpStatus.Series#CLIENT_ERROR} or
     * {@link HttpStatus.Series#SERVER_ERROR}.
     */
    public boolean isError() {
        return (is4xxClientError() || is5xxServerError());
    }

    /**
     * 返回此状态代码的字符串表示形式
     */
    @Override
    public String toString() {
        return this.value + " " + name();
    }


    /**
     * 根据状态码返回 httpStatus，如果没有此状态码，则返回异常
     * @param statusCode 要返回的枚举的数值
     * @return 具有指定数值的枚举常量
     * @throws IllegalArgumentException 如果此枚举没有指定数值的常量
     */
    public static HttpStatus valueOf(int statusCode) {
        HttpStatus status = resolve(statusCode);
        if (status == null) {
            throw new IllegalArgumentException("No matching constant for [" + statusCode + "]");
        }
        return status;
    }

    /**
     * 根据状态码返回 httpStatus，如果没有此状态码，则返回null
     * @param statusCode 要返回的枚举的数值
     * @return 具有指定数值的枚举常量 如果没有，则返回null
     */
    public static HttpStatus resolve(int statusCode) {
        // Use cached VALUES instead of values() to prevent array allocation.
        for (HttpStatus status : VALUES) {
            if (status.value == statusCode) {
                return status;
            }
        }
        return null;
    }


    /**
     * HTTP状态系列的枚举。
     */
    public enum Series {

        INFORMATIONAL(1),
        SUCCESSFUL(2),
        REDIRECTION(3),
        CLIENT_ERROR(4),
        SERVER_ERROR(5);

        private final int value;

        Series(int value) {
            this.value = value;
        }

        /**
         * 返回此状态系列的整数值。范围从 1 到 5。
         */
        public int value() {
            return this.value;
        }

    }
}
