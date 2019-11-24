SUMMARY = "Firmware files for mn88436"
LICENSE = "CLOSED"
require conf/license/license-close.inc

inherit allarch

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/firmware-mn88436.zip"

SRC_URI[md5sum] = "35f12b3b8cf7fab84d9c85516afa9d30"
SRC_URI[sha256sum] = "721c1bb9880592d8b8abb85e659d38f1c0963079d897f04ba3f9df8f12cfd948"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    install -m 0644 dvb-fe-mn88436-atsc.fw ${D}${nonarch_base_libdir}/firmware/dvb-fe-mn88436-atsc.fw
    install -m 0644 dvb-fe-mn88436-pseq.fw ${D}${nonarch_base_libdir}/firmware/dvb-fe-mn88436-pseq.fw
}
