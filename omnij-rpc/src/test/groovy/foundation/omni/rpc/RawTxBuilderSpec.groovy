package foundation.omni.rpc

import spock.lang.Shared
import spock.lang.Specification

import static foundation.omni.CurrencyID.MSC


/**
 * RawTxBuilder unit tests
 */
class RawTxBuilderSpec extends Specification {
    @Shared
    RawTxBuilder builder

    def setup() {
        builder = new RawTxBuilder()
    }

    def "The generated hex-encoded transaction matches a valid reference transaction"() {
        when:
        def txHex = builder.createDexSellOfferHex(MSC, 1.0, 0.2, (Byte) 10, 0.0001, (Byte) 1)

        then:
        txHex == "00010014000000010000000005f5e1000000000001312d000a000000000000271001"
    }
}