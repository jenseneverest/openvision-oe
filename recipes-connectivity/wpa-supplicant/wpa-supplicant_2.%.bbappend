DEPENDS += "openssl"

inherit upx_compress

do_configure_append() {
        sed -e '/^CONFIG_TLS = gnutls/d' -i wpa_supplicant/.config
}
