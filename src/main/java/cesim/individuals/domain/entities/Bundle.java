package cesim.individuals.domain.entities;

import java.time.Instant;
import java.util.List;

public record Bundle(
        Identifier identifier,
        Bundle.BundleType type,
        Instant timestamp,
        Long total,
        List<Bundle.Link> link,
        List<Bundle.Entry> entry,
        Signature signature,
        Resourse issues
) {

  public enum BundleType {
    DOCUMENT("document"),
    MESSAGE("message"),
    TRANSACTION("transaction"),
    TRANSACTION_RESPONSE("transaction-response"),
    BATCH("batch"),
    BATCH_RESPONSE("batch-response"),
    HISTORY("history"),
    SEARCHSET("searchset"),
    COLLECTION("collection"),
    SUBSCRIPTION_NOTIFICATION("subscription-notification");

    private final String value;

    BundleType(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }
  }

  public record Link(
          String relation,
          String url
  ) {
  }

  public record Entry(
          List<Bundle.Link> link,
          String fullUrl,
          Resourse resource,
          Entry.Search search,
          Entry.Request request,
          Entry.Response response
  ) {
    public record Search(
            Search.Mode mode,
            Double score
    ) {

      public enum Mode {
        MATCH("match"),
        INCLUDE("include");

        private final String value;

        Mode(String value) {
          this.value = value;
        }

        public String getValue() {
          return value;
        }
      }
    }

    public record Request(
            Request.Method method,
            String url,
            String ifNoneMatch,
            Instant ifModifiedSince,
            String ifMatch,
            String ifNoneExist
    ) {

      public enum Method {
        GET("GET"),
        HEAD("HEAD"),
        POST("POST"),
        PUT("PUT"),
        DELETE("DELETE"),
        PATCH("PATCH");

        private final String value;

        Method(String value) {
          this.value = value;
        }

        public String getValue() {
          return value;
        }
      }
    }

    public record Response(
            String status,
            String location,
            String etag,
            Instant lastModified,
            Object outcome
    ) {
    }
  }
}
