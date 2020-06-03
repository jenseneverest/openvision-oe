LICENSE = "CLOSED"
SRC_URI = "https://raw.githubusercontent.com/OpenVisionE2/linux-firmwares/master/mn8847x.zip"

SRC_URI[md5sum] = "cdd7da2423417aa0024998ae77e86ad8"
SRC_URI[sha256sum] = "23bebdfe5b10eff4434093e915f52b51bb06481a6715954acec2c97685c945ff"

S = "${WORKDIR}"

PACKAGES = "${PN}"
FILES_${PN} += "${nonarch_base_libdir}/firmware"

inherit allarch

SUMMARY = "Firmware for mn8847x"

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware
    install -m 0644 mn88472.fw ${D}${nonarch_base_libdir}/firmware/mn88472.fw
    install -m 0644 dvb-demod-mn88472-02.fw ${D}${nonarch_base_libdir}/firmware/dvb-demod-mn88472-02.fw
    install -m 0644 mn88473.fw ${D}${nonarch_base_libdir}/firmware/mn88473.fw
    install -m 0644 mn88473.fw ${D}${nonarch_base_libdir}/firmware/dvb-demod-mn88473-01.fw
}
