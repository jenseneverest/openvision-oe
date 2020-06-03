LICENSE = "CLOSED"
require conf/license/license-close.inc

SUMMARY = "Firmware for ds3xxx dvb frontend"
inherit allarch

SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/fw-ds3xxx.tar.gz"

SRC_URI[md5sum] = "b09621dae49fece2959134750a8cf5a1"
SRC_URI[sha256sum] = "fb43e95c485dcad113aba9699bff3a7b16e38919324ab079569023a6a7ecd9f4"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    install -m 0755 dvb-fe-ds300x.fw ${D}${nonarch_base_libdir}/firmware/dvb-fe-ds300x.fw
    install -m 0755 dvb-fe-ds3103.fw ${D}${nonarch_base_libdir}/firmware/dvb-fe-ds3103.fw
}

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"
