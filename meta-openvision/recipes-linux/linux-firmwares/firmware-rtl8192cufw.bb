LICENSE = "CLOSED"
require conf/license/license-close.inc

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/rtl8192cufw_TMSC.zip"

SRC_URI[md5sum] = "fbdc2178258a6afb3378b8e3dab709fa"
SRC_URI[sha256sum] = "2bed1a398f43146ff0c9e12b70a976043cfee0b699ea0788a7ff50e8214e92fa"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"

inherit allarch

SUMMARY = "Firmware for rtl8192cufw_TMSC"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    install -d ${D}${nonarch_base_libdir}/firmware/rtlwifi
    install -m 0644 rtl8192cufw_TMSC.bin ${D}${nonarch_base_libdir}/firmware/rtlwifi
}
