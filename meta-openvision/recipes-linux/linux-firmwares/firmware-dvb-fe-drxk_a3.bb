LICENSE = "CLOSED"
require conf/license/license-close.inc

SUMMARY = "Firmware for drxk dvb-c/dvb-t dvb frontend"
inherit allarch

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/drxk_a3.tar.gz"

SRC_URI[md5sum] = "475a5df8329d9b1c12988cf85b0c5823"
SRC_URI[sha256sum] = "fa5cd6f2fe894d1a1cb1d7f9b039a7417a026f20e7a01083791cae8ab6ca3819"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    install -m 0755 drxk_a3.mc ${D}${nonarch_base_libdir}/firmware/drxk_a3.mc
}

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"
